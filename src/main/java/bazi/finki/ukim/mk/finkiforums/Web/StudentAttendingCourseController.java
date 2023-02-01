package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import bazi.finki.ukim.mk.finkiforums.Service.StudentAttendingCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    @GetMapping()
    public List<StudentAttendingCourse> findAllCoursesForStudent(@RequestParam(name = "username") String username){
        return this.studentAttendingCourseService.findAllByStudentUsername(username);
    }
    @GetMapping("/add")
    public StudentAttendingCourse addCourseToStudent(@RequestParam(name = "username") String username,
                                                           @RequestParam(name = "selectedCourse") String selectedCourse){
        return this.studentAttendingCourseService.addCourseToStudent(username,Long.parseLong(selectedCourse));
    }
}
