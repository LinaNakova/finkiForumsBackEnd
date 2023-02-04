package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorReaction;

import java.util.List;

public interface ProfessorReactionService {
    List<ProfessorReaction> findAllReactionsByProfessors();
    void saveReaction(Long id, String username, Boolean reaction);
}
