package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.MaterialAboutQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialAboutQuestionRepository extends JpaRepository<MaterialAboutQuestion, Long> {

}
