package com.vareli.tecsoft.service;

import org.springframework.http.ResponseEntity;

public interface DashboardService {

    ResponseEntity<?> fetchQueryCount();
    
}
