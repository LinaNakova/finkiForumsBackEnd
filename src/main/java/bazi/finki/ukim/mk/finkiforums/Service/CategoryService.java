package bazi.finki.ukim.mk.finkiforums.Service;

import bazi.finki.ukim.mk.finkiforums.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findById(Long id);
}
