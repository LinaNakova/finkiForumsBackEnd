package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorConsults;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorConsultsRepository;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorConsultsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorConsultsServiceImpl implements ProfessorConsultsService {
    private final ProfessorConsultsRepository professorConsultsRepository;

    public ProfessorConsultsServiceImpl(ProfessorConsultsRepository professorConsultsRepository) {
        this.professorConsultsRepository = professorConsultsRepository;
    }


    @Override
    public List<ProfessorConsults> findAllConsults() {
        return this.professorConsultsRepository.findAll();
    }
}
