package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Answer;
import bazi.finki.ukim.mk.finkiforums.Service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/all")
    public List<Answer> findAllAnswers(){
        return this.answerService.findAllAnswers();
    }

    @GetMapping("/question/{id}")
    public List<Answer> findAllAnswersForQuestion(@PathVariable Long id){
        return this.answerService.findAllByQuestionId(id);
    }
}
