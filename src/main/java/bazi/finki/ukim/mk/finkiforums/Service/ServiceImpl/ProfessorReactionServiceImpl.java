package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.InavlidStudentReaction;
import bazi.finki.ukim.mk.finkiforums.Model.*;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorReactionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.AnswerService;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorReactionService;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorReactionServiceImpl implements ProfessorReactionService {

    private final ProfessorReactionRepository professorReactionRepository;
    private final ProfessorService professorService;
    private final AnswerService answerService;

    public ProfessorReactionServiceImpl(ProfessorReactionRepository professorReactionRepository, ProfessorService professorService, AnswerService answerService) {
        this.professorReactionRepository = professorReactionRepository;
        this.professorService = professorService;
        this.answerService = answerService;
    }

    @Override
    public List<ProfessorReaction> findAllReactionsByProfessors() {
        return this.professorReactionRepository.findAll();
    }

    @Override
    public void saveReaction(Long id, String username, Boolean reaction) {
        Professor professor = this.professorService.findProfessorByUsername(username);
        Answer answer = this.answerService.findById(id);
        if (this.professorReactionRepository.findByAnswerIdAndProfessorUsername(id, username).isPresent()){
            ProfessorReaction professorReaction = this.professorReactionRepository.findByAnswerIdAndProfessorUsername(id, username)
                    .orElseThrow(InavlidStudentReaction::new);
            professorReaction.setReaction(reaction);
            this.professorReactionRepository.save(professorReaction);
        }
        else {
            this.professorReactionRepository.save(new ProfessorReaction(professor, answer, reaction));
        }
    }
}
