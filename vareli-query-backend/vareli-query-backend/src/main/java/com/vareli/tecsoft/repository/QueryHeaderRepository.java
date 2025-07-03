package com.vareli.tecsoft.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vareli.tecsoft.model.QueryHeader;

public interface QueryHeaderRepository extends JpaRepository<QueryHeader, Long>{

  List<QueryHeader> findAllByProject(String project);

    @Query(value = "SELECT project, count(id) FROM trn_query_hdr group by project", nativeQuery = true)
     List<Map<String, Integer>> countProjectWise();
    
}
