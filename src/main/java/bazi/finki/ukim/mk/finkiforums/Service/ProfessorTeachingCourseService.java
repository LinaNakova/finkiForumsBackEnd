package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorTeachingCourse;
import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;

import java.util.List;

public interface ProfessorTeachingCourseService {
    List<ProfessorTeachingCourse> findAllProfessorsTeachingCourses();
    List<ProfessorTeachingCourse> findAllByProfessorUsername(String username);

    ProfessorTeachingCourse addCourseToProfessor(String username, long selectedCourse);
}
