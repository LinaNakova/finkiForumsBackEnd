package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.MaterialAboutQuestion;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialAboutQuestionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/material-questions")
public class MaterialAboutQuestionController {
    private final MaterialAboutQuestionService materialAboutQuestionService;

    public MaterialAboutQuestionController(MaterialAboutQuestionService materialAboutQuestionService) {
        this.materialAboutQuestionService = materialAboutQuestionService;
    }
    @GetMapping("/all")
    public List<MaterialAboutQuestion> findAllMaterialAboutQuestions(){
        return this.materialAboutQuestionService.findAllMaterialAboutQuestion();
    }
}
