package com.example.aero.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QCatLim {
    @JsonProperty("sub_module_ids")
    List<Integer> subModuleListId;
    @JsonProperty("q_limit")
    int qLimit;
}
