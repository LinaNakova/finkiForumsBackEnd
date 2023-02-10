package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidCategoryIdException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidQuestionIdException;
import bazi.finki.ukim.mk.finkiforums.Model.Category;
import bazi.finki.ukim.mk.finkiforums.Model.Question;
import bazi.finki.ukim.mk.finkiforums.Model.QuestionTaggedWithCategory;
import bazi.finki.ukim.mk.finkiforums.Repository.CategoryRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.QuestionRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.QuestionTaggedWithCategoryRepository;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionTaggedWithCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTaggedWithCategoryServiceImpl implements QuestionTaggedWithCategoryService {

    private final QuestionTaggedWithCategoryRepository questionTaggedWithCategoryRepository;
    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    public QuestionTaggedWithCategoryServiceImpl(QuestionTaggedWithCategoryRepository questionTaggedWithCategoryRepository, QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.questionTaggedWithCategoryRepository = questionTaggedWithCategoryRepository;
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<QuestionTaggedWithCategory> findAllTaggedQuestions() {
        return questionTaggedWithCategoryRepository.findAll();
    }

    @Override
    public QuestionTaggedWithCategory save(Long questionId, Long categoryId) {
        if (this.questionRepository.findById(questionId).isPresent()){
            if (this.categoryRepository.findById(categoryId).isPresent()){
                Question question = this.questionRepository.findById(questionId).get();
                Category category = this.categoryRepository.findById(categoryId).get();
                return questionTaggedWithCategoryRepository.save(new QuestionTaggedWithCategory(question,category));
            }
            throw new InvalidCategoryIdException(categoryId);
        }
        throw new InvalidQuestionIdException(questionId);
    }
}
