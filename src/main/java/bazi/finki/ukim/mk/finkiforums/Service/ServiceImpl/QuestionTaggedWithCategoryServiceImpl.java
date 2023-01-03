package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.QuestionTaggedWithCategory;
import bazi.finki.ukim.mk.finkiforums.Repository.QuestionTaggedWithCategoryRepository;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionTaggedWithCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTaggedWithCategoryServiceImpl implements QuestionTaggedWithCategoryService {

    private final QuestionTaggedWithCategoryRepository questionTaggedWithCategoryRepository;

    public QuestionTaggedWithCategoryServiceImpl(QuestionTaggedWithCategoryRepository questionTaggedWithCategoryRepository) {
        this.questionTaggedWithCategoryRepository = questionTaggedWithCategoryRepository;
    }

    @Override
    public List<QuestionTaggedWithCategory> findAllTaggedQuestions() {
        return questionTaggedWithCategoryRepository.findAll();
    }
}
