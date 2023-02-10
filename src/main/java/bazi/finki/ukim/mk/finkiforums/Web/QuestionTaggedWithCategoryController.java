package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.QuestionTaggedWithCategory;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionTaggedWithCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/tagged-questions")
public class QuestionTaggedWithCategoryController {
    private final QuestionTaggedWithCategoryService questionTaggedWithCategoryService;

    public QuestionTaggedWithCategoryController(QuestionTaggedWithCategoryService questionTaggedWithCategoryService) {
        this.questionTaggedWithCategoryService = questionTaggedWithCategoryService;
    }

    @GetMapping("/all")
    public List<QuestionTaggedWithCategory> findAllTaggedQuestions(){
        return this.questionTaggedWithCategoryService.findAllTaggedQuestions();
    }

    @GetMapping("/add/{categoryId}")
    public QuestionTaggedWithCategory save(@RequestParam Long questionId, @PathVariable Long categoryId){
        return this.questionTaggedWithCategoryService.save(questionId,categoryId);
    }
}
