package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorTeachingCourse;
import bazi.finki.ukim.mk.finkiforums.Repository.ProfessorTeachingCourseRepository;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorTeachingCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorTeachingCourseServiceImpl implements ProfessorTeachingCourseService {
    private final ProfessorTeachingCourseRepository professorTeachingCourseRepository;

    public ProfessorTeachingCourseServiceImpl(ProfessorTeachingCourseRepository professorTeachingCourseRepository) {
        this.professorTeachingCourseRepository = professorTeachingCourseRepository;
    }

    @Override
    public List<ProfessorTeachingCourse> findAllProfessorsTeachingCourses() {
        return this.professorTeachingCourseRepository.findAll();
    }

    @Override
    public List<ProfessorTeachingCourse> findAllByProfessorUsername(String username) {
        return this.professorTeachingCourseRepository.findAllByProfessorUsername(username);
    }
}
