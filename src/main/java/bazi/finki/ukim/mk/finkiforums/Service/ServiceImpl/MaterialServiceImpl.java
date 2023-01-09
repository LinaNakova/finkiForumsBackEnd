package bazi.finki.ukim.mk.finkiforums.Service.ServiceImpl;

import bazi.finki.ukim.mk.finkiforums.Model.Material;
import bazi.finki.ukim.mk.finkiforums.Repository.MaterialRepository;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }
}
