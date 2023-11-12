package com.example.aero.services;

import com.example.aero.dto.Question;
import com.example.aero.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question getById(int id) {
        return questionRepository.findById(id).get();
    }

    public List<Question> getByCategory(int categoryId) {
        return questionRepository.getQuestionByGroupId(categoryId);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
