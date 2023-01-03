package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorReaction;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorReactionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorReactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorReactionServiceImpl implements ProfessorReactionService {

    private final ProfessorReactionRepository professorReactionRepository;

    public ProfessorReactionServiceImpl(ProfessorReactionRepository professorReactionRepository) {
        this.professorReactionRepository = professorReactionRepository;
    }

    @Override
    public List<ProfessorReaction> findAllReactionsByProfessors() {
        return this.professorReactionRepository.findAll();
    }
}
