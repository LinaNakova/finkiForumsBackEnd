package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Exceptions.InvalidCourseIdException;
import bazi.finki.ukim.mk.finkiforums.Model.Course;
import bazi.finki.ukim.mk.finkiforums.Model.Subject;
import bazi.finki.ukim.mk.finkiforums.Repository.CourseRepository;
import bazi.finki.ukim.mk.finkiforums.Service.CourseService;
import bazi.finki.ukim.mk.finkiforums.Service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final SubjectService subjectService;

    public CourseServiceImpl(CourseRepository courseRepository, SubjectService subjectService) {
        this.courseRepository = courseRepository;
        this.subjectService = subjectService;
    }

    @Override
    public List<Course> findAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> findAllCoursesBySubjectId(Long id) {
        Subject subject = this.findSubjectById(id);
        return this.courseRepository.findAllByPrId(subject);
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new InvalidCourseIdException(id));
    }

    private Subject findSubjectById(Long id){
        return this.subjectService.findById(id);
    }
}
