package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorReaction;
import bazi.finki.ukim.mk.finkiforums.Model.StudentReaction;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorReactionService;
import bazi.finki.ukim.mk.finkiforums.Service.StudentReactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    private final ProfessorReactionService professorReactionService;
    private final StudentReactionService studentReactionService;

    public ReactionController(ProfessorReactionService professorReactionService, StudentReactionService studentReactionService) {
        this.professorReactionService = professorReactionService;
        this.studentReactionService = studentReactionService;
    }

    @GetMapping("/professors/all")
    public List<ProfessorReaction> findAllReactionsByProfessors(){
        return this.professorReactionService.findAllReactionsByProfessors();
    }
    @GetMapping("/students/all")
    public List<StudentReaction> findAllReactionsByStudents(){
        return this.studentReactionService.findAllReactionsByStudents();
    }
}
