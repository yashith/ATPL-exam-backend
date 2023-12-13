package com.example.aero.controllers;

import com.example.aero.dto.SubModule;
import com.example.aero.dto.SubModuleWithN;
import com.example.aero.repository.SubModuleRepository;
import com.example.aero.services.QuestionService;
import com.example.aero.services.SubModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/submodules")
public class SubModuleController {

    @Autowired
    SubModuleService subModuleService;
    @Autowired
    QuestionService questionService;

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
    public List<SubModuleWithN> getSubModuleForCategory(@PathVariable int cId) {
        List<SubModule> subModuleList = subModuleService.getSubModuleByCategoryId(cId);
        List <SubModuleWithN> subModuleQuestionCountList = new ArrayList<>();
        for (SubModule subModule:subModuleList){
            int c = questionService.getNumberOfQuestionsForSubModule(subModule.getId());
            SubModuleWithN moduleWithN = new SubModuleWithN();
            moduleWithN.setId(subModule.getId());
            moduleWithN.setCategory(subModule.getCategory());
            moduleWithN.setName(subModule.getName());
            moduleWithN.setNQuestions(c);
            subModuleQuestionCountList.add(moduleWithN);
        }
        return subModuleQuestionCountList;
    }

    @CrossOrigin
    @PostMapping("/add")
    public SubModule addSubModule(@RequestBody SubModule subModule){
        return subModuleService.addSubModule(subModule);
    }
}
