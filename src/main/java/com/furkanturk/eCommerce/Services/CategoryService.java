package com.furkanturk.eCommerce.Services;

import com.furkanturk.eCommerce.Models.Category;
import com.furkanturk.eCommerce.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category>  getAllCategories(){
        List<Category> categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            return Collections.emptyList();
        }else {
            return categoryRepository.findAll();
        }
    }
    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
}
