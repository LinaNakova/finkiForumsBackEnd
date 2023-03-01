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
            case 1 -> {
                sql = """
                        select q3.maximum, p3.*
                        from (
                                 select max(q2.count) as maximum, q2.pra_id
                                 from(
                                         select distinct q.count, q.pra_id as pra_id
                                         from(
                                                 select count(distinct o.o_id), p.pra_id as pra_id from project.prasanja p
                                                                                                            join project.odgovori o on p.pra_id = o.pra_id
                                                 where o.p_id is not null and
                                                     p.pra_datum between now()-interval '4 months' and now()
                                                 group by p.pra_id

                                             ) as q
                                                 join project.prasanja p on q.pra_id = p.pra_id
                                                 join project.odgovori o on o.pra_id = p.pra_id
                                         where q.count >=2 and o.o_validen is true
                                     ) as q2
                                         join project.prasanja p2 on p2.pra_id = q2.pra_id
                                 group by q2.pra_id
                                 order by maximum desc
                                 limit 1
                             ) as q3
                                 join project.prasanja p3 on q3.pra_id = p3.pra_id""";
                return jdbcTemplate.queryForList(sql);
            }
            case 2 -> {
                sql = """
                         select pras.*, q2.sum
                         from (select distinct q1.pra_id, sum(q1.br_reakcii_total)
                               from (select brnio.br_reakcii_total, p.*
                                     from project.broj_reakcii_na_izbrani_odgovori brnio
                                              join project.prasanja p on brnio.pra_id = p.pra_id
                                              join project.odgovori o on brnio.o_id = o.o_id
                                     where brnio.br_reakcii_total >=
                                           (select avg(brno.br_reakcii_total) from project.broj_reakcii_na_odgovor brno)) as q1
                               group by q1.pra_id) as q2
                                  join project.prasanja as pras on pras.pra_id = q2.pra_id;""";
                return jdbcTemplate.queryForList(sql);
            }
            case 3 -> {
                sql = """
                        select parts.p_korisnicko_ime korisnicko_ime, parts.rejt + parts.mat + parts.kurs as vk
                        from (select prof.p_korisnicko_ime,
                                     case when top_odg.num_rejting is null then 0 else top_odg.num_rejting end as rejt,
                                     case when najm_mat.num_mat is null then 0 else najm_mat.num_mat end       as mat,
                                     case when najm_kurs.num_kurs is null then 0 else najm_kurs.num_kurs end   as kurs
                              from project.profesori prof
                                       left join
                                   (select o.p_id, q1.c1 + q2.c2 as num_rejting
                                    from project.odgovori o
                                             join
                                         (select o.o_id, count(o.o_id) c1
                                          from project.odgovori o
                                                   left join dava_reakcija dr on o.o_id = dr.o_id
                                          where o.p_id is not null
                                            and dr.reakcija is true
                                          group by o.o_id) q1 on o.o_id = q1.o_id
                                             join
                                         (select o.o_id, count(o.o_id) c2
                                          from project.odgovori o
                                                   left join project.reagira_na rn on o.o_id = rn.o_id
                                          where o.p_id is not null
                                            and rn.reakcija is true
                                          group by o.o_id) q2 on o.o_id = q2.o_id
                                    order by num_rejting desc) top_odg on prof.p_id = top_odg.p_id
                                       left join
                                   (select p.p_id, count(m.m_id) num_mat
                                    from project.materijali m
                                             join project.profesori p on m.p_id = p.p_id
                                    group by p.p_id) najm_mat on prof.p_id = najm_mat.p_id
                                       left join
                                   (select p.p_id, count(epn.p_id) num_kurs
                                    from project.kursevi ku
                                             join project.e_prof_na epn on ku.ku_id = epn.ku_id
                                             join project.profesori p on epn.p_id = p.p_id
                                    group by p.p_id) najm_kurs on prof.p_id = najm_kurs.p_id) as parts
                        order by vk desc
                        limit 5""";
                return jdbcTemplate.queryForList(sql);
            }
            case 4 -> {
                sql = """
                        select pr.pr_id, pr.pr_ime, q1.ku_ime, q1.br_isti_kategorii, count(distinct q2.pra_id) as br_prasanja
                        from project.predmeti pr
                                 join project.kursevi ku on pr.pr_id = ku.pr_id
                                 join
                             (select ku.ku_id, ku.ku_ime, count(*) br_isti_kategorii
                              from project.kursevi ku
                                       left join project.prasanja pra on ku.ku_id = pra.ku_id
                                       left join project.e_oznaceno_so eos on pra.pra_id = eos.pra_id
                                       left join project.materijali m on ku.ku_id = m.ku_id
                              where eos.ka_id = m.ka_id
                              group by ku.ku_id, ku.ku_ime
                              having count(*) >= 2
                              order by br_isti_kategorii desc
                              limit 3) q1 on ku.ku_id = q1.ku_id
                                 join
                             (select pras.ku_id as ku_id, pras.pra_id
                              from project.prasanja pras
                              where now() >= pras.pra_datum
                                and age(now(), pras.pra_datum) <= interval '3 months') q2 on ku.ku_id = q2.ku_id
                        group by pr.pr_id, pr.pr_ime, q1.ku_ime, q1.br_isti_kategorii

                        order by br_prasanja desc""";
                return jdbcTemplate.queryForList(sql);
            }
            case 5 -> {
                sql = """
                        select prof.p_ime, prof.p_prezime, q3.najbrzo_vreme
                        from project.profesori prof
                                 join (select q2.p_id, min(q2.avg_vreme) najbrzo_vreme
                                       from (select q1.p_id, avg(q1.vreme_odg) avg_vreme
                                             from (select o.p_id, age(o.o_datum,p.pra_datum) vreme_odg
                                                   from project.odgovori o
                                                            join project.prasanja p on o.pra_id = p.pra_id
                                                   where o.p_id is not null) q1
                                             group by q1.p_id) q2
                                       group by q2.p_id
                                       order by 2
                                       limit 1) q3 on prof.p_id = q3.p_id

                        """;
                return jdbcTemplate.queryForList(sql);
            }
        }
        return null;
    }
}
