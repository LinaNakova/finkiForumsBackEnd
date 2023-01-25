package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Question;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public List<Question> findAllQuestions(){
        return this.questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public List<Question> findAllQuestionsForCourse(@PathVariable Long id){
        return this.questionService.findAllQuestionsByCourse(id);
    }

    @GetMapping("/question/{id}")
    public Question findQuestionById(@PathVariable Long id){
        return this.questionService.findById(id);
    }

}
