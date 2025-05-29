package com.vareli.tecsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.model.dto.QueryInputDto;
import com.vareli.tecsoft.service.QueryService;

@RestController
@RequestMapping("/api/open")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/addQuery")
    public ResponseEntity<?> addQuery(@RequestBody List<QueryInputDto> inputList) {
        return queryService.addQuery(inputList);
    }
}
