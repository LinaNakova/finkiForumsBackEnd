package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.ProfessorConsults;
import bazi.finki.ukim.mk.finkiforums.Service.ProfessorConsultsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/professor-consults")
public class ProfessorConsultsController {
    private final ProfessorConsultsService professorConsultsService;

    public ProfessorConsultsController(ProfessorConsultsService professorConsultsService) {
        this.professorConsultsService = professorConsultsService;
    }

    @GetMapping("/all")
    private List<ProfessorConsults> findAllConsults(){
        return this.professorConsultsService.findAllConsults();
    }
}
