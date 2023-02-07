package bazi.finki.ukim.mk.finkiforums.Web;


import bazi.finki.ukim.mk.finkiforums.Model.Material;
import bazi.finki.ukim.mk.finkiforums.Service.LoginService;
import bazi.finki.ukim.mk.finkiforums.Service.MaterialService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@CrossOrigin
@RestController
@RequestMapping("api/materials")
public class MaterialController {
    private final MaterialService materialService;
    private final LoginService loginService;

    public MaterialController(MaterialService materialService, LoginService loginService) {
        this.materialService = materialService;
        this.loginService = loginService;
    }

    @GetMapping("/all")
    public List<Material> findAllMaterials() {
        return this.materialService.findAllMaterials();
    }

    @GetMapping("/all/{courseId}")
    public List<String> findAllMaterialsForCourseId(@PathVariable Long courseId) {
        return this.materialService.findAllMaterialsForCourseId(courseId);
    }

    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/ForUploading/";

    @PostMapping("/upload/{courseId}")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles,
                                                    @PathVariable Long courseId) {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            filenames.add(StringUtils.cleanPath(file.getOriginalFilename()));
            this.materialService.save(file.getOriginalFilename(), this.loginService.getActiveProfessorUsername(), courseId);
        }
        return ResponseEntity.ok().body(filenames);
    }

    @GetMapping("download/{filename}")
    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }
}
