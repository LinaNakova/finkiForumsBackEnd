package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Answer;
import bazi.finki.ukim.mk.finkiforums.Repository.AnswerRepository;
import bazi.finki.ukim.mk.finkiforums.Service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> findAllAnswers() {
        return this.answerRepository.findAll();
    }

    @Override
    public List<Answer> findAllByQuestionId(Long id) {
        return this.answerRepository.findAllByQuestionId(id);
    }
}
