package com.vareli.tecsoft.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "trn_query_hdr")
public class QueryHeader {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @OneToMany(mappedBy = "queryHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<QueryDetails> queryDetails;
     
}
