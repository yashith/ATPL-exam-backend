package com.example.aero.repository;

import com.example.aero.dto.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubModuleRepository extends JpaRepository<SubModule, Integer> {

    @Query("SELECT sm FROM SubModule sm where sm.Category=:catId")
    List<SubModule> getSubModuleForCategory(@Param("catId") int catId);
}
