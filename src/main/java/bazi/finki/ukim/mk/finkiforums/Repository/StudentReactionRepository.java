package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.StudentReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentReactionRepository extends JpaRepository<StudentReaction, Long> {
    List<StudentReaction> findAllByAnswerIdAndReaction(Long id, Boolean reaction);
    Optional<StudentReaction> findByAnswerIdAndStudentUsername(Long id, String username);
}
