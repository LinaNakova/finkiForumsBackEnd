package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Service.AdminPanelService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    private final JdbcTemplate jdbcTemplate;

    public AdminPanelServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> getStats(int id) {
        String sql;
        switch (id) {
            case 1:
                sql = "select q3.maximum, p3.*\n" +
                        "from (\n" +
                        "         select max(q2.count) as maximum, q2.pra_id\n" +
                        "         from(\n" +
                        "                 select distinct q.count, q.pra_id as pra_id\n" +
                        "                 from(\n" +
                        "                         select count(distinct o.o_id), p.pra_id as pra_id from project.prasanja p\n" +
                        "                                                                                    join project.odgovori o on p.pra_id = o.pra_id\n" +
                        "                         where o.p_id is not null and\n" +
                        "                             p.pra_datum between now()-interval '4 months' and now()\n" +
                        "                         group by p.pra_id\n" +
                        "\n" +
                        "                     ) as q\n" +
                        "                         join project.prasanja p on q.pra_id = p.pra_id\n" +
                        "                         join project.odgovori o on o.pra_id = p.pra_id\n" +
                        "                 where q.count >=2 and o.o_validen is true\n" +
                        "             ) as q2\n" +
                        "                 join project.prasanja p2 on p2.pra_id = q2.pra_id\n" +
                        "         group by q2.pra_id\n" +
                        "         order by maximum desc\n" +
                        "         limit 1\n" +
                        "     ) as q3\n" +
                        "         join project.prasanja p3 on q3.pra_id = p3.pra_id";
                return jdbcTemplate.queryForList(sql);
            case 2:
                sql = "select brnio.br_reakcii_total, p.* from project.broj_reakcii_na_izbrani_odgovori brnio\n" +
                        "                                            join project.prasanja p on brnio.pra_id  = p.pra_id\n" +
                        "where brnio.br_reakcii_total >= (select avg(brno.br_reakcii_total) from project.broj_reakcii_na_odgovor brno)\n";
                return jdbcTemplate.queryForList(sql);
            case 3:
                sql = "select parts.p_korisnicko_ime korisnicko_ime, parts.rejt + parts.mat + parts.kurs as vk\n" +
                        "from (select prof.p_korisnicko_ime,\n" +
                        "             case when top_odg.num_rejting is null then 0 else top_odg.num_rejting end as rejt,\n" +
                        "             case when najm_mat.num_mat is null then 0 else najm_mat.num_mat end       as mat,\n" +
                        "             case when najm_kurs.num_kurs is null then 0 else najm_kurs.num_kurs end   as kurs\n" +
                        "      from project.profesori prof\n" +
                        "               left join\n" +
                        "           (select o.p_id, q1.c1 + q2.c2 as num_rejting\n" +
                        "            from project.odgovori o\n" +
                        "                     join\n" +
                        "                 (select o.o_id, count(o.o_id) c1\n" +
                        "                  from project.odgovori o\n" +
                        "                           left join dava_reakcija dr on o.o_id = dr.o_id\n" +
                        "                  where o.p_id is not null\n" +
                        "                    and dr.reakcija is true\n" +
                        "                  group by o.o_id) q1 on o.o_id = q1.o_id\n" +
                        "                     join\n" +
                        "                 (select o.o_id, count(o.o_id) c2\n" +
                        "                  from project.odgovori o\n" +
                        "                           left join project.reagira_na rn on o.o_id = rn.o_id\n" +
                        "                  where o.p_id is not null\n" +
                        "                    and rn.reakcija is true\n" +
                        "                  group by o.o_id) q2 on o.o_id = q2.o_id\n" +
                        "            order by num_rejting desc) top_odg on prof.p_id = top_odg.p_id\n" +
                        "               left join\n" +
                        "           (select p.p_id, count(m.m_id) num_mat\n" +
                        "            from project.materijali m\n" +
                        "                     join project.profesori p on m.p_id = p.p_id\n" +
                        "            group by p.p_id) najm_mat on prof.p_id = najm_mat.p_id\n" +
                        "               left join\n" +
                        "           (select p.p_id, count(epn.p_id) num_kurs\n" +
                        "            from project.kursevi ku\n" +
                        "                     join project.e_prof_na epn on ku.ku_id = epn.ku_id\n" +
                        "                     join project.profesori p on epn.p_id = p.p_id\n" +
                        "            group by p.p_id) najm_kurs on prof.p_id = najm_kurs.p_id) as parts\n" +
                        "order by vk desc\n"+
                        "limit 5";
                return jdbcTemplate.queryForList(sql);
            case 4:
                sql = "select pr.pr_id, pr.pr_ime, q1.ku_ime, q1.br_isti_kategorii, count(distinct q2.pra_id) as br_prasanja\n" +
                        "from project.predmeti pr\n" +
                        "         join project.kursevi ku on pr.pr_id = ku.pr_id\n" +
                        "         join\n" +
                        "     (select ku.ku_id, ku.ku_ime, count(*) br_isti_kategorii\n" +
                        "      from project.kursevi ku\n" +
                        "               left join project.prasanja pra on ku.ku_id = pra.ku_id\n" +
                        "               left join project.e_oznaceno_so eos on pra.pra_id = eos.pra_id\n" +
                        "               left join project.materijali m on ku.ku_id = m.ku_id\n" +
                        "      where eos.ka_id = m.ka_id\n" +
                        "      group by ku.ku_id, ku.ku_ime\n" +
                        "      having count(*) >= 2\n" +
                        "      order by br_isti_kategorii desc\n" +
                        "      limit 3) q1 on ku.ku_id = q1.ku_id\n" +
                        "         join\n" +
                        "     (select pras.ku_id as ku_id, pras.pra_id\n" +
                        "      from project.prasanja pras\n" +
                        "      where now() >= pras.pra_datum\n" +
                        "        and age(now(), pras.pra_datum) <= interval '3 months') q2 on ku.ku_id = q2.ku_id\n" +
                        "group by pr.pr_id, pr.pr_ime, q1.ku_ime, q1.br_isti_kategorii\n" +
                        "\n" +
                        "order by br_prasanja desc";
                return jdbcTemplate.queryForList(sql);
            case 5:
                sql = "select prof.p_ime, prof.p_prezime, q3.najbrzo_vreme\n" +
                        "from project.profesori prof\n" +
                        "         join (select q2.p_id, min(q2.avg_vreme) najbrzo_vreme\n" +
                        "               from (select q1.p_id, avg(q1.vreme_odg) avg_vreme\n" +
                        "                     from (select o.p_id, age(o.o_datum,p.pra_datum) vreme_odg\n" +
                        "                           from project.odgovori o\n" +
                        "                                    join project.prasanja p on o.pra_id = p.pra_id\n" +
                        "                           where o.p_id is not null) q1\n" +
                        "                     group by q1.p_id) q2\n" +
                        "               group by q2.p_id\n" +
                        "               order by 2\n" +
                        "               limit 1) q3 on prof.p_id = q3.p_id\n" +
                        "\n";
                return jdbcTemplate.queryForList(sql);
        }
        return null;
    }
}
