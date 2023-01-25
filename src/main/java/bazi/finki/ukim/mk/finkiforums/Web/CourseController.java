package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Course;
import bazi.finki.ukim.mk.finkiforums.Service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public List<Course> findAllCourses(){
        return this.courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public List<Course> findAllCoursesBySubjectId(@PathVariable Long id){
        return this.courseService.findAllCoursesBySubjectId(id);
    }
    @GetMapping("/course/{id}")
    public Course findCourse(@PathVariable Long id){
        return this.courseService.findById(id);
    }

}
