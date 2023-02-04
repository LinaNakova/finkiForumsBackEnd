package bazi.finki.ukim.mk.finkiforums.Web;

import bazi.finki.ukim.mk.finkiforums.Model.Category;
import bazi.finki.ukim.mk.finkiforums.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> findAllCategories(){
        return this.categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {return this.categoryService.findById(id);}
}
