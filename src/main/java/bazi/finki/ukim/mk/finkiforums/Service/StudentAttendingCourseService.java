package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;

import java.util.List;

public interface StudentAttendingCourseService {
    List<StudentAttendingCourse> findAllStudentsAndAllCourse();
    List<StudentAttendingCourse> findAllByStudentUsername(String username);
}
