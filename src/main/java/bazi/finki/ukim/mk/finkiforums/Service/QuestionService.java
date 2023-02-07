package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();
    List<Question> findAllQuestionsByCourse(Long id);
    Question findById(Long id);
    Question save(String title, String content, String studentUserame, Long courseId);
    Integer findLikesForAnswer(Long id);
}
