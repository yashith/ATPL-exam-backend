package com.example.aero.controllers;

import com.example.aero.dto.Answer;
import com.example.aero.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/answers")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @CrossOrigin
    @GetMapping("/get/{qId}")
    List<Answer> getAnswersForQuestion(@PathVariable("qId") int qId) {
        return answerService.getAnswersForQuestion(qId);
    }

    @PostMapping("/add")
    Answer addAnswer(@RequestBody Answer answer){
        return answerService.addAnswer(answer);}
}
