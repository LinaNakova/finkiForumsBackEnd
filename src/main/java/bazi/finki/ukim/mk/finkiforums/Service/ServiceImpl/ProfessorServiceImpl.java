package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Model.Professor;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorRepository;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAllProfessors() {
        return this.professorRepository.findAll();
    }

    @Override
    public Professor findByUsername(String username) {
        return this.professorRepository.findByUsername(username)
                .orElseThrow(() -> new BadUsernameException(username));
    }

    @Override
    public Professor findProfessorByUsername(String username) {
        return this.professorRepository.findByUsername(username)
                .orElseThrow(() -> new BadUsernameException(username));
    }
}
