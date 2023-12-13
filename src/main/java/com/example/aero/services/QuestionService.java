package com.example.aero.services;

import com.example.aero.dto.Question;
import com.example.aero.model.QCatLim;
import com.example.aero.model.QuestionAnswers;
import com.example.aero.repository.AnswerRepository;
import com.example.aero.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Question getById(int id) {
        return questionRepository.findById(id).get();
    }

    public List<Question> getByCategory(int subModuleId) {
        return questionRepository.getQuestionByGroupId(subModuleId);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getForCategoryList(QCatLim qcatLim) {
        List<Integer> subModuleList= qcatLim.getSubModuleListId();
        int limit = qcatLim.getQLimit();
        if(limit != 0){
            Long qCount = questionRepository.countAllQuestionForCategories(subModuleList);
            Long qty = qCount%limit==0?qCount/limit:(qCount/limit)+1;
            int idx = (int)(Math.random() * qty);
            Pageable pageable = PageRequest.of(idx,limit);
            return questionRepository.getQuestionForCategories(subModuleList,pageable);
        }else {
            return questionRepository.getAllQuestionForCategories(subModuleList);
        }


    }
    public List<QuestionAnswers> getQuestionsWithAnswers(QCatLim qcatLim){
        List<Question> questions = getForCategoryList(qcatLim);
        List<QuestionAnswers> qnas= new ArrayList<>();
        for(Question question:questions){
            QuestionAnswers qna = new QuestionAnswers(question.getId(),question.getSubModuleId(),question.getQuestion());
            qna.setAnswers(answerRepository.findAnswerByQuestionId(question.getId()));
            qnas.add(qna);
        }
        return qnas;
    }
    public int getNumberOfQuestionsForSubModule(int subModuleId){
        List<Integer> subModuleList = new ArrayList<>();
        subModuleList.add(subModuleId);
        return (int)questionRepository.countAllQuestionForCategories(subModuleList);
    }

}
