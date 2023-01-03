package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import bazi.finki.ukim.mk.finkiforums.Service.StudentAttendingCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student-courses")
public class StudentAttendingCourseController {
    private final StudentAttendingCourseService studentAttendingCourseService;

    public StudentAttendingCourseController(StudentAttendingCourseService studentAttendingCourseService) {
        this.studentAttendingCourseService = studentAttendingCourseService;
    }
    @GetMapping("/all")
    public List<StudentAttendingCourse> findAllStudentsAndAllCourse(){
        return this.studentAttendingCourseService.findAllStudentsAndAllCourse();
    }
}
