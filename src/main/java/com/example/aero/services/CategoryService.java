package com.example.aero.services;

import com.example.aero.dto.Category;
import com.example.aero.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getById(int id) {
        return categoryRepository.findById(id).get();
    }

    public Category getByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
