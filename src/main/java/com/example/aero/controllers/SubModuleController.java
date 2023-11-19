package com.example.aero.controllers;

import com.example.aero.dto.SubModule;
import com.example.aero.repository.SubModuleRepository;
import com.example.aero.services.SubModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/submodules")
public class SubModuleController {

    @Autowired
    SubModuleService subModuleService;

    @CrossOrigin
    @GetMapping("/get/{id}")
    public SubModule getSubModuleById(@PathVariable int id) {
        try {
            return subModuleService.getSubModuleById(id);
        }catch (NoSuchElementException e){
            return new SubModule();
        }
    }

    @CrossOrigin
    @GetMapping("/get/category/{cId}")
    public List<SubModule> getSubModuleForCategory(@PathVariable int cId) {
        return subModuleService.getSubModuleByCategoryId(cId);
    }

    @CrossOrigin
    @PostMapping("/add")
    public SubModule addSubModule(@RequestBody SubModule subModule){
        return subModuleService.addSubModule(subModule);
    }
}
