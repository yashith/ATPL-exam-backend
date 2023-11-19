package com.example.aero.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SubModule {
    @Id
    int id;
    String name;
    @JsonProperty("category")
    int Category;
}
