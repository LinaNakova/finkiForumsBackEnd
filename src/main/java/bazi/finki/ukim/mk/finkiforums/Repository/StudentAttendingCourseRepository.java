package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.StudentAttendingCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAttendingCourseRepository extends JpaRepository<StudentAttendingCourse, Long> {
    List<StudentAttendingCourse> findAllByStudentUsername(String username);
}
