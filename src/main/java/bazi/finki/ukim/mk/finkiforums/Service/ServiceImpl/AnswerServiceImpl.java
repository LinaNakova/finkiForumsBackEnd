package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Enumerations.UserType;
import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidQuestionIdException;
import bazi.finki.ukim.mk.finkiforums.Model.Answer;
import bazi.finki.ukim.mk.finkiforums.Model.Professor;
import bazi.finki.ukim.mk.finkiforums.Model.Question;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Repository.AnswerRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.QuestionRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentRepository;
import bazi.finki.ukim.mk.finkiforums.Response.UserResponse;
import bazi.finki.ukim.mk.finkiforums.Service.AnswerService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, StudentRepository studentRepository, ProfessorRepository professorRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Answer> findAllAnswers() {
        return this.answerRepository.findAll();
    }

    @Override
    public List<Answer> findAllByQuestionId(Long id) {
        return this.answerRepository.findAllByQuestionId(id);
    }

    @Override
    public Answer save(String content, String username, Long questionId) {
        if (this.questionRepository.findById(questionId).isPresent()) {
            Question question = this.questionRepository.findById(questionId).get();

            if (this.studentRepository.findByUsername(username).isPresent()) {
                Student student = this.studentRepository.findByUsername(username).get();
                return answerRepository.save(new Answer(content, false, Timestamp.from(Instant.now()), question,student,null));
            } else if (this.professorRepository.findByUsername(username).isPresent()) {
                Professor professor = this.professorRepository.findByUsername(username).get();
                return answerRepository.save(new Answer(content, false, Timestamp.from(Instant.now()), question,null,professor));
            }
            throw new BadUsernameException(username);
        }
        else{
            throw new InvalidQuestionIdException(questionId);
        }
    }
}
