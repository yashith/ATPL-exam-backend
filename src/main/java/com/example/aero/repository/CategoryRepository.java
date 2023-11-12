package com.example.aero.repository;

import com.example.aero.dto.Category;
import com.example.aero.dto.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name =:name")
    Category getCategoryByName(@Param("name") String name);
}
