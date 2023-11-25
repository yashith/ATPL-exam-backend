package com.example.aero.model;

import com.example.aero.dto.Answer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionAnswers {
    private int id;
    @JsonProperty("sub_module_id")
    private int subModuleId;
    private String question;
    private List<Answer> answers;

    public QuestionAnswers(int id, int subModuleId, String question) {
        this.id = id;
        this.subModuleId = subModuleId;
        this.question = question;
    }
}
