package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.MaterialAboutQuestion;
import bazi.finki.ukim.mk.finkiforums.Repository.MaterialAboutQuestionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialAboutQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialAboutQuestionServiceImpl implements MaterialAboutQuestionService {
    private final MaterialAboutQuestionRepository materialAboutQuestionRepository;

    public MaterialAboutQuestionServiceImpl(MaterialAboutQuestionRepository materialAboutQuestionRepository) {
        this.materialAboutQuestionRepository = materialAboutQuestionRepository;
    }

    @Override
    public List<MaterialAboutQuestion> findAllMaterialAboutQuestion() {
        return materialAboutQuestionRepository.findAll();
    }
}
