package com.vareli.tecsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vareli.tecsoft.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;


    @GetMapping("/fetchQueryCount")
    public ResponseEntity<?> fetchQueryCount() {
        return dashboardService.fetchQueryCount();
    }

}
