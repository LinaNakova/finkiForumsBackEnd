package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Course;

import java.util.List;

public interface CourseService {
     List<Course> findAllCourses();
     List<Course> findAllCoursesBySubjectId(Long id);
     Course findById(Long id);
}
