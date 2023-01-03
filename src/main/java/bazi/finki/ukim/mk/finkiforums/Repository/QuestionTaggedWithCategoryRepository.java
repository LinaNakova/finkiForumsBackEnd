package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.QuestionTaggedWithCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTaggedWithCategoryRepository extends JpaRepository<QuestionTaggedWithCategory, Long> {
}
