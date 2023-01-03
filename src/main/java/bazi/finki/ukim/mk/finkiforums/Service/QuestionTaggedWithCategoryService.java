package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.QuestionTaggedWithCategory;

import java.util.List;

public interface QuestionTaggedWithCategoryService {
    List<QuestionTaggedWithCategory> findAllTaggedQuestions();
}
