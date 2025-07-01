package com.vareli.tecsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vareli.tecsoft.model.QueryHeader;

public interface QueryHeaderRepository extends JpaRepository<QueryHeader, Long>{

  List<QueryHeader> findAllByProject(String project);
    
}
