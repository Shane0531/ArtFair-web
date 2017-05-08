package com.sylc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class KnowledgeComment extends Comment{

  @JoinColumn(name = "articleIdx")
  @ManyToOne
  @JsonIgnore
  KnowledgeArticle article;
}
