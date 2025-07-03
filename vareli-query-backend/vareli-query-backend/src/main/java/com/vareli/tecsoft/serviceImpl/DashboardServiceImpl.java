package com.vareli.tecsoft.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vareli.tecsoft.repository.QueryHeaderRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    private QueryHeaderRepository queryHeaderRepository;

    @Override
    public ResponseEntity<?> fetchQueryCount() {
       List<Map<String, Integer>> countProjectWise = queryHeaderRepository.countProjectWise();
      return  ResponseHandler.generateResponse("Successfully Fetch Details!..", HttpStatus.OK, countProjectWise);

    }
    
}
