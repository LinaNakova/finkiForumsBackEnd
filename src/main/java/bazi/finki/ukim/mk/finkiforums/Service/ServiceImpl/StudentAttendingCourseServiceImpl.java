package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import bazi.finki.ukim.mk.finkiforums.Repository.StudentAttendingCourseRepository;
import bazi.finki.ukim.mk.finkiforums.Service.StudentAttendingCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendingCourseServiceImpl implements StudentAttendingCourseService {

    private final StudentAttendingCourseRepository studentAttendingCourseRepository;

    public StudentAttendingCourseServiceImpl(StudentAttendingCourseRepository studentAttendingCourseRepository) {
        this.studentAttendingCourseRepository = studentAttendingCourseRepository;
    }

    public List<StudentAttendingCourse> findAllStudentsAndAllCourse(){
        return this.studentAttendingCourseRepository.findAll();
    }

    @Override
    public List<StudentAttendingCourse> findAllByStudentUsername(String username) {
        return this.studentAttendingCourseRepository.findAllByStudentUsername(username);
    }
}
