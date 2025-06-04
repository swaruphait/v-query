package com.vareli.tecsoft.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.model.OptionList;
import com.vareli.tecsoft.model.QuestionList;
import com.vareli.tecsoft.model.dto.QuestionListDto;
import com.vareli.tecsoft.repository.QuestionListRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionListRepository questionListRepository;

    @Override
    public ResponseEntity<?> addQuestion(QuestionListDto dto) {
        QuestionList question = new QuestionList();
        question.setName(dto.getName());
        question.setQsnType(dto.getQsnType());
        question.setMultipleChoose(dto.isMultipleChoose());
        question.setProject(dto.getProject());
        question.setMandatory(dto.isMandatory());
        question.setStatus(true);

        if (dto.getOptionLists()!=null) {
             List<OptionList> options = dto.getOptionLists().stream().map(optDto -> {
            OptionList opt = new OptionList();
            opt.setName(optDto.getName());
            opt.setQuestionList(question); 
            return opt;
        }).collect(Collectors.toList());

        question.setOptionLists(options);
        }
       
         QuestionList save = questionListRepository.save(question);

        return  ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, save);

    }

    @Override
    public ResponseEntity<?> findQuestionById(Integer id) {
        Optional<QuestionList> byId = questionListRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, byId);
        } else {
            return ResponseHandler.generateResponse("No Details Found this Id!..", HttpStatus.BAD_REQUEST, null);
        }
    }

    @Override
    public ResponseEntity<?> findByAllActiveQuestion(String name) {
      List<QuestionList> collect = questionListRepository.fetchQuestionProjectWise(name);
       return ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, collect);
    }

    @Override
    public ResponseEntity<?> findByAllQuestion() {
       List<QuestionList> collect = questionListRepository.findAll();
       return ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, collect);
    }

    @Override
    public ResponseEntity<?> activeQuestion(Integer id) {
       Optional<QuestionList> byId = questionListRepository.findById(id);
       if (!byId.get().isStatus()) {
        byId.get().setStatus(true);
        questionListRepository.save( byId.get());
       return ResponseHandler.generateResponse("Successfully Activated!..", HttpStatus.OK, null);
       } else {
            return ResponseHandler.generateResponse("Question Already Activated!..", HttpStatus.BAD_REQUEST, null);
       }
    }

    @Override
    public ResponseEntity<?> deactiveQuestion(Integer id) {
        Optional<QuestionList> byId = questionListRepository.findById(id);
       if (byId.get().isStatus()) {
        byId.get().setStatus(false);
        questionListRepository.save( byId.get());
       return ResponseHandler.generateResponse("Successfully DeActivated!..", HttpStatus.OK, null);
       } else {
            return ResponseHandler.generateResponse("Question Already DeActivated!..", HttpStatus.BAD_REQUEST, null);
       }
    }

}
