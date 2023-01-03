package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.StudentReaction;

import java.util.List;

public interface StudentReactionService {
    List<StudentReaction> findAllReactionsByStudents();
}
