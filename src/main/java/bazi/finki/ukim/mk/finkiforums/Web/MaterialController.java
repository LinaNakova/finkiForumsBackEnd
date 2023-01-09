package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Material;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/materials")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/all")
    public List<Material> findAllMaterials(){
        return this.materialService.findAllMaterials();
    }
}
