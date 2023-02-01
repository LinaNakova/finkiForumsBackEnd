package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.BadUsernameException;
import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidCourseIdException;
import bazi.finki.ukim.mk.finkiforums.Model.Course;
import bazi.finki.ukim.mk.finkiforums.Model.Student;
import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import bazi.finki.ukim.mk.finkiforums.Repository.CourseRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentAttendingCourseRepository;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentRepository;
import bazi.finki.ukim.mk.finkiforums.Service.StudentAttendingCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendingCourseServiceImpl implements StudentAttendingCourseService {

    private final StudentAttendingCourseRepository studentAttendingCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentAttendingCourseServiceImpl(StudentAttendingCourseRepository studentAttendingCourseRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentAttendingCourseRepository = studentAttendingCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentAttendingCourse> findAllStudentsAndAllCourse(){
        return this.studentAttendingCourseRepository.findAll();
    }

    @Override
    public List<StudentAttendingCourse> findAllByStudentUsername(String username) {
        return this.studentAttendingCourseRepository.findAllByStudentUsername(username);
    }

    @Override
    public StudentAttendingCourse addCourseToStudent(String username, Long selectedCourse) {
        Student student = studentRepository.findByUsername(username).orElseThrow(()->new BadUsernameException(username));
        Course course = courseRepository.findById(selectedCourse).orElseThrow(()->new InvalidCourseIdException(selectedCourse));
        return this.studentAttendingCourseRepository.save(new StudentAttendingCourse(student,course));
    }
}
