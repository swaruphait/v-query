package com.vareli.tecsoft.model.dto;

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
    private Object ans;     
    private Object ansid;   
}
