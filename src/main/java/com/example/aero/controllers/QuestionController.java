package com.example.aero.controllers;

import com.example.aero.dto.Question;
import com.example.aero.model.QCatLim;
import com.example.aero.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @CrossOrigin
    @GetMapping("/get/{id}")
    Question getQuestion(@PathVariable int id) {
        try {
            return questionService.getById(id);
        } catch (NoSuchElementException e) {
            return new Question();
        }
    }

    @CrossOrigin
    @GetMapping("/get/category/{mId}")
    List<Question> getQuestionByCategory(@PathVariable int mId) {
        return questionService.getByCategory(mId);
    }

    @CrossOrigin
    @PostMapping("/add")
    Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @CrossOrigin
    @PostMapping("/get/categories")
    List<Question> getQuestionForCategoryList(@RequestBody QCatLim qcatLim) {
        return questionService.getForCategoryList(qcatLim);
    }
}
