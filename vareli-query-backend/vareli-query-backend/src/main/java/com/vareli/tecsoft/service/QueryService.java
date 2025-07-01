package com.vareli.tecsoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vareli.tecsoft.model.dto.QueryInputDto;

public interface QueryService {

    ResponseEntity<?> addQuery(List<QueryInputDto> inputList);

    ResponseEntity<?> fetchAllQuery();

    ResponseEntity<?> fetchQueryData(String name);


    
}
