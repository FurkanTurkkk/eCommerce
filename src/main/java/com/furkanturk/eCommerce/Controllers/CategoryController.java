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
            return ResponseEntity.ok().header("Liste Başarıyla Getirildi...").build();
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
            return ResponseEntity.ok(category.get());
        }
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}
