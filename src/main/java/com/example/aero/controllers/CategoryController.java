package com.example.aero.controllers;

import com.example.aero.dto.Category;
import com.example.aero.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories/get")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }

    @PostMapping("/categories/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.add(category);
    }


}
