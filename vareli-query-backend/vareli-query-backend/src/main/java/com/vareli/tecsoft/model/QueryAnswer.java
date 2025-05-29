package com.vareli.tecsoft.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "trn_query_ans")
@JsonIgnoreProperties({"queryDetails" })
public class QueryAnswer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;  
   private String ans;
   private String ansId;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "query_qsn_no", nullable = false)
   private QueryDetails queryDetails; 
}
