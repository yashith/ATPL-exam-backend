package com.example.aero.controllers;

import com.example.aero.dto.Question;
import com.example.aero.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/get/{id}")
    Question getQuestion(@PathVariable int id) {
        Question testq = questionService.getById(id);
        return testq;
    }

    @PostMapping("/get/category/{cId}")
    List<Question> getQuestionByCategory(@PathVariable int cId) {
        return questionService.getByCategory(cId);
    }

    @PostMapping("/add")
    Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

}
