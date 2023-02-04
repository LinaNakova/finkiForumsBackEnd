package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorReactionRepository extends JpaRepository<ProfessorReaction, Long> {
    List<ProfessorReaction> findAllByAnswerIdAndReaction(Long id, Boolean reaction);
    Optional<ProfessorReaction> findByAnswerIdAndProfessorUsername(Long id, String username);
}
