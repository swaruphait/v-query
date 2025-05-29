package com.vareli.tecsoft.service;

import org.springframework.http.ResponseEntity;

import com.vareli.tecsoft.model.dto.QuestionListDto;

public interface QuestionService {

    ResponseEntity<?> addQuestion(QuestionListDto qList);

    ResponseEntity<?> findQuestionById(Integer id);

    ResponseEntity<?> findByAllActiveQuestion(String name);

    ResponseEntity<?> findByAllQuestion();

    ResponseEntity<?> activeQuestion(Integer id);

    ResponseEntity<?> deactiveQuestion(Integer id);
    
}
