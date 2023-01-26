package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorTeachingCourse;
import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorTeachingCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/professor-courses")
public class ProfessorTeachingCourseController {
    private final ProfessorTeachingCourseService professorTeachingCourseService;

    public ProfessorTeachingCourseController(ProfessorTeachingCourseService professorTeachingCourseService) {
        this.professorTeachingCourseService = professorTeachingCourseService;
    }

    @GetMapping("/all")
    public List<ProfessorTeachingCourse> findAllProfessorsTeachingCourses(){
        return this.professorTeachingCourseService.findAllProfessorsTeachingCourses();
    }
    @GetMapping()
    public List<ProfessorTeachingCourse> findAllCoursesForProfessor(@RequestParam(name = "username") String username){
        return this.professorTeachingCourseService.findAllByProfessorUsername(username);
    }
    @GetMapping("/add")
    public ProfessorTeachingCourse addCourseToProfessor(@RequestParam(name = "username") String username,
                                                     @RequestParam(name = "selectedCourse") String selectedCourse){
        return this.professorTeachingCourseService.addCourseToProfessor(username,Long.parseLong(selectedCourse));
    }
}
