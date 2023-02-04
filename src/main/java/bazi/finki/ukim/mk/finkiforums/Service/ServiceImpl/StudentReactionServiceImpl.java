package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InavlidStudentReaction;
import bazi.finki.ukim.mk.finkiforums.Model.Answer;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Model.StudentReaction;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentReactionRepository;
import bazi.finki.ukim.mk.finkiforums.Service.AnswerService;
import bazi.finki.ukim.mk.finkiforums.Service.StudentReactionService;
import bazi.finki.ukim.mk.finkiforums.Service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReactionServiceImpl implements StudentReactionService {

    private final StudentReactionRepository studentReactionRepository;
    private final StudentService studentService;
    private final AnswerService answerService;

    public StudentReactionServiceImpl(StudentReactionRepository studentReactionRepository, StudentService studentService, AnswerService answerService) {
        this.studentReactionRepository = studentReactionRepository;
        this.studentService = studentService;
        this.answerService = answerService;
    }

    @Override
    public List<StudentReaction> findAllReactionsByStudents() {
        return this.studentReactionRepository.findAll();
    }

    @Override
    public void saveReaction(Long id, String username, Boolean reaction) {
        Student student = this.studentService.findStudentByUsername(username);
        Answer answer = this.answerService.findById(id);
        if (this.studentReactionRepository.findByAnswerIdAndStudentUsername(id, username).isPresent()){
            StudentReaction studentReaction = this.studentReactionRepository.findByAnswerIdAndStudentUsername(id, username)
                    .orElseThrow(InavlidStudentReaction::new);
            studentReaction.setReaction(reaction);
            this.studentReactionRepository.save(studentReaction);
        }
        else {
            this.studentReactionRepository.save(new StudentReaction(student, answer, reaction));
        }
    }
}
