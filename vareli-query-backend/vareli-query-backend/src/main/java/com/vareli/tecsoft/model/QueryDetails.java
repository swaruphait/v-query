package com.vareli.tecsoft.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "trn_query_dtls")
@JsonIgnoreProperties({"queryHeader" })
public class QueryDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; 
   private Integer qsnId;
   private String qsn;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "query_no", nullable = false)
   private QueryHeader queryHeader; 

   @OneToMany(mappedBy = "queryDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<QueryAnswer> queryAnswers;
}
