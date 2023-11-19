package com.example.aero.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
    @Id
    private int id;
    @JsonProperty("sub_module_id")
    private int subModuleId;
    private String question;
}
