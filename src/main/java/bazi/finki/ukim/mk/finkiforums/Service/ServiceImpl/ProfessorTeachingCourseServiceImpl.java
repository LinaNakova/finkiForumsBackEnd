package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidCourseIdException;
import bazi.finki.ukim.mk.finkiforums.Model.*;
import bazi.finki.ukim.mk.finkiforums.Repository.CourseRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorTeachingCourseRepository;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorTeachingCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorTeachingCourseServiceImpl implements ProfessorTeachingCourseService {
    private final ProfessorTeachingCourseRepository professorTeachingCourseRepository;
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public ProfessorTeachingCourseServiceImpl(ProfessorTeachingCourseRepository professorTeachingCourseRepository, ProfessorRepository professorRepository, CourseRepository courseRepository) {
        this.professorTeachingCourseRepository = professorTeachingCourseRepository;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<ProfessorTeachingCourse> findAllProfessorsTeachingCourses() {
        return this.professorTeachingCourseRepository.findAll();
    }

    @Override
    public List<ProfessorTeachingCourse> findAllByProfessorUsername(String username) {
        return this.professorTeachingCourseRepository.findAllByProfessorUsername(username);
    }

    @Override
    public ProfessorTeachingCourse addCourseToProfessor(String username, long selectedCourse) {
        Professor professor = professorRepository.findByUsername(username).orElseThrow(()->new BadUsernameException(username));
        Course course = courseRepository.findById(selectedCourse).orElseThrow(()->new InvalidCourseIdException(selectedCourse));
        ProfessorTeachingCourse professorTeachingCourse = new ProfessorTeachingCourse();
        professorTeachingCourse.setProfessor(professor);
        professorTeachingCourse.setCourse(course);
        return this.professorTeachingCourseRepository.save(professorTeachingCourse);
    }
}
