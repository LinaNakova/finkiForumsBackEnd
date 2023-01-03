package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Question;
import bazi.finki.ukim.mk.finkiforums.Repository.QuestionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAllQuestions() {
        return this.questionRepository.findAll();
    }
}
