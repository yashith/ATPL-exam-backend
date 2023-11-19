package com.example.aero.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    private int id;
    @JsonProperty("question_id")
    private int questionId;
    private String answer;
    @JsonProperty("is_image")
    private boolean isImage;
    @JsonProperty("is_correct_answer")
    private boolean isCorrectAnswer;

}
