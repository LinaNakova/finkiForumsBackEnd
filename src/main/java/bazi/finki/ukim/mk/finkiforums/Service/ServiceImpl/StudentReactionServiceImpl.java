package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorReaction;
import bazi.finki.ukim.mk.finkiforums.Model.StudentReaction;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentReactionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.StudentReactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReactionServiceImpl implements StudentReactionService {

    private final StudentReactionRepository studentReactionRepository;

    public StudentReactionServiceImpl(StudentReactionRepository studentReactionRepository) {
        this.studentReactionRepository = studentReactionRepository;
    }

    @Override
    public List<StudentReaction> findAllReactionsByStudents() {
        return this.studentReactionRepository.findAll();
    }
}
