package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Service.ProfessorReactionService;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/professor-reacts")
public class ProfessorReactionController {
    private final ProfessorReactionService professorReactionService;
    private final QuestionService questionService;

    public ProfessorReactionController(ProfessorReactionService professorReactionService, QuestionService questionService) {
        this.professorReactionService = professorReactionService;
        this.questionService = questionService;
    }

    @PostMapping("/like/{id}")
    public Integer likeAnswer(@PathVariable Long id,
                              @RequestBody String username) {
        this.professorReactionService.saveReaction(id, username, true);
        return this.questionService.findLikesForAnswer(id);
    }

    @PostMapping("/unlike/{id}")
    public Integer unlikeAnswer(@PathVariable Long id,
                                @RequestBody String username) {
        this.professorReactionService.saveReaction(id, username, false);
        return this.questionService.findLikesForAnswer(id);
    }
}
