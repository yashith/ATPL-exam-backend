package com.example.aero.controllers;

import com.example.aero.dto.Category;
import com.example.aero.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @CrossOrigin
    @GetMapping("/get")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }

    @CrossOrigin
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.add(category);
    }


}
