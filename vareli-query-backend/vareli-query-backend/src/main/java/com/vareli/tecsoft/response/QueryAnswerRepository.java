package com.vareli.tecsoft.response;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vareli.tecsoft.model.QueryAnswer;

public interface QueryAnswerRepository extends JpaRepository<QueryAnswer, Long>{
    
}
