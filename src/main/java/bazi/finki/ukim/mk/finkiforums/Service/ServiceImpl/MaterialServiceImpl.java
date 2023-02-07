package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Course;
import bazi.finki.ukim.mk.finkiforums.Model.Material;
import bazi.finki.ukim.mk.finkiforums.Model.Professor;
import bazi.finki.ukim.mk.finkiforums.Repository.MaterialRepository;
import bazi.finki.ukim.mk.finkiforums.Service.CourseService;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialService;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final ProfessorService professorService;
    private final CourseService courseService;

    public MaterialServiceImpl(MaterialRepository materialRepository, ProfessorService professorService, CourseService courseService) {
        this.materialRepository = materialRepository;
        this.professorService = professorService;
        this.courseService = courseService;
    }

    @Override
    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public List<String> findAllMaterialsForCourseId(Long id) {
        return this.materialRepository.findByCourseId(id).stream().map(Material::getName).collect(Collectors.toList());
    }

    @Override
    public void save(String name, String username, Long courseId) {
        Professor professor = this.professorService.findByUsername(username);
        Course course = this.courseService.findById(courseId);
        this.materialRepository.save(new Material(name, professor, course));
    }
}
