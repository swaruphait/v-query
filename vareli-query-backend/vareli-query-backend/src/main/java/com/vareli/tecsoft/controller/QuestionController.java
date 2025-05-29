package com.vareli.tecsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.model.dto.QuestionListDto;
import com.vareli.tecsoft.service.QuestionService;


@RestController
@RequestMapping("/api/open")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

     @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionListDto qList ) {
        return questionService.addQuestion(qList);
    }

    @GetMapping("/findByAllQuestion")
    public ResponseEntity<?> findByAllQuestion() {
        return questionService.findByAllQuestion();
    }

    @GetMapping("/findByAllActiveQuestion")
    public ResponseEntity<?> findByAllActiveQuestion(@RequestParam String name) {
        return questionService.findByAllActiveQuestion(name);
    }

    @GetMapping("/findQuestionById")
    public ResponseEntity<?> findQuestionById(@RequestParam Integer id) {
        return questionService.findQuestionById(id);
    }

    @PutMapping("/activeQuestion")
    public ResponseEntity<?> activeQuestion(@RequestParam Integer id) {
        return questionService.activeQuestion(id);
    }

    @PutMapping("/deactiveQuestion")
    public ResponseEntity<?> deactiveQuestion(@RequestParam Integer id) {
        return questionService.deactiveQuestion(id);
    }
}
