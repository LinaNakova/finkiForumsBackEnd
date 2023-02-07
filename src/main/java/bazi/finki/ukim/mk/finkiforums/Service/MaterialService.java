package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAllMaterials();
    List<String> findAllMaterialsForCourseId(Long id);
    void save(String name, String username, Long courseId);
}
