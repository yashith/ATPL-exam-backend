package com.example.aero.controllers;

import com.example.aero.dto.Answer;
import com.example.aero.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping("/get/{qId}")
    List<Answer> getAnswersForQuestion(@PathVariable("qId") int qId) {
        return answerService.getAnswersForQuestion(qId);
    }

}
