package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorTeachingCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorTeachingCourseRepository extends JpaRepository<ProfessorTeachingCourse, Long> {
    List<ProfessorTeachingCourse> findAllByProfessorUsername(String username);
}
