package com.furkanturk.eCommerce.Controllers;

import com.furkanturk.eCommerce.Models.Category;
import com.furkanturk.eCommerce.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        if(categoryService.getAllCategories().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Liste Bulunamadı!").build();
        }
        else {
            List<Category> categories=categoryService.getAllCategories();
            return ResponseEntity.ok(categories);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Optional<Category> category=categoryService.getCategoryById(id);
        if(category.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Kategori Bulunamadı")
                    .build();
        }
        else {
            return ResponseEntity.ok().header("Kategori Getirildi").build();
        }
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        List<Category> category1=categoryService.getAllCategories();
        if(category1.contains(category)){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Kategori Mevcut Eklenemedi.")
                    .build();
        }else{
            categoryService.createCategory(category);
            return ResponseEntity.ok().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
