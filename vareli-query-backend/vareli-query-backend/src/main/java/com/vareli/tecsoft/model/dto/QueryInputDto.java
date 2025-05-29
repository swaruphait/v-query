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
public class QueryInputDto {
    private Integer id;
    private String qsn;
    private List<String> ans;     
    private List<Long> ansid;   
}
