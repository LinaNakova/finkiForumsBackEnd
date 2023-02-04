package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidCourseIdException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidQuestionIdException;
import bazi.finki.ukim.mk.finkiforums.Model.Course;
import bazi.finki.ukim.mk.finkiforums.Model.Question;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Repository.*;
import bazi.finki.ukim.mk.finkiforums.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ProfessorReactionRepository professorReactionRepository;
    private final StudentReactionRepository studentReactionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, StudentRepository studentRepository, CourseRepository courseRepository, ProfessorReactionRepository professorReactionRepository, StudentReactionRepository studentReactionRepository) {
        this.questionRepository = questionRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.professorReactionRepository = professorReactionRepository;
        this.studentReactionRepository = studentReactionRepository;
    }

    @Override
    public List<Question> findAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public List<Question> findAllQuestionsByCourse(Long id) {
        return this.questionRepository.findAllByCourseId(id);
    }

    @Override
    public Question findById(Long id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new InvalidQuestionIdException(id));
    }

    @Override
    public Question save(String title, String content, String studentUserame, Long courseId) {
        if (this.studentRepository.findByUsername(studentUserame).isPresent()) {
            if (this.courseRepository.findById(courseId).isPresent()) {
                Student student = studentRepository.findByUsername(studentUserame).get();
                Course course = courseRepository.findById(courseId).get();
                return questionRepository.save(new Question(title, content, Timestamp.from(Instant.now()), student, course));
            }
            throw new InvalidCourseIdException(courseId);
        }
        throw new BadUsernameException(studentUserame);
    }

    @Override
    public Integer findLikesForAnswer(Long id) {
        Integer professorPositiveReactions = this.professorReactionRepository.findAllByAnswerIdAndReaction(id, true).size();
        Integer studentPositiveReactions = this.studentReactionRepository.findAllByAnswerIdAndReaction(id, true).size();
        Integer professorNegativeReactions = this.professorReactionRepository.findAllByAnswerIdAndReaction(id, false).size();
        Integer studentNegativeReactions = this.studentReactionRepository.findAllByAnswerIdAndReaction(id, false).size();
        return (professorPositiveReactions + studentPositiveReactions) - (professorNegativeReactions+studentNegativeReactions);
    }
}
