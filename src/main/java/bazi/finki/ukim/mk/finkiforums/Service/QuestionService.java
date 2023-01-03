package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();
}
