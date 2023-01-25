package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAllAnswers();
    List<Answer> findAllByQuestionId(Long id);
}
