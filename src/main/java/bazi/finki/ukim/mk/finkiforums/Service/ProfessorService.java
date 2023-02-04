package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> findAllProfessors();
    Professor findProfessorByUsername(String username);
}
