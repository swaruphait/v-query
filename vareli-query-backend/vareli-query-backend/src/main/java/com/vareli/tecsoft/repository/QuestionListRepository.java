package com.vareli.tecsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vareli.tecsoft.model.QuestionList;


public interface QuestionListRepository extends JpaRepository<QuestionList, Integer>{

@Query(value = "SELECT * FROM mst_qsn where project= ?1 and status is true", nativeQuery = true)
List<QuestionList> fetchQuestionProjectWise(String name);
    
}
