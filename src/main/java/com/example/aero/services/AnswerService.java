package com.example.aero.services;

import com.example.aero.dto.Answer;
import com.example.aero.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAnswersForQuestion(int id) {
        return answerRepository.findAnswerByQuestionId(id);
    }

    public Answer getAnswerById(int id) {
        return answerRepository.findById(id).get();
    }

    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
