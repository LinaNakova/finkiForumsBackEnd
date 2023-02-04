package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Service.QuestionService;
import bazi.finki.ukim.mk.finkiforums.Service.StudentReactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-reacts")
@CrossOrigin
public class StudentReactsController {

    private final StudentReactionService studentReactionService;
    private final QuestionService questionService;

    public StudentReactsController(StudentReactionService studentReactionService, QuestionService questionService) {
        this.studentReactionService = studentReactionService;
        this.questionService = questionService;
    }

    @PostMapping("/like/{id}")
    public Integer likeAnswer(@PathVariable Long id,
                              @RequestBody String username) {
        this.studentReactionService.saveReaction(id, username, true);
        return this.questionService.findLikesForAnswer(id);
    }

    @PostMapping("/unlike/{id}")
    public Integer unlikeAnswer(@PathVariable Long id,
                                @RequestBody String username) {
        this.studentReactionService.saveReaction(id, username, false);
        return this.questionService.findLikesForAnswer(id);
    }
}
