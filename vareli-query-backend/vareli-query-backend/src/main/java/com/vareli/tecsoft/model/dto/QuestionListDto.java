package com.vareli.tecsoft.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionListDto {
    private String name;
    private String qsnType;
    private boolean multipleChoose;
    private List<OptionListDto> optionLists;
    private String project;
     private boolean mandatory;
    private boolean status;
}
