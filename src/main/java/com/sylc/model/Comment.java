package com.sylc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class Comment {
  @Id
  @GeneratedValue
  int idx;

  @JoinColumn(name = "userIdx")
  @ManyToOne
  @JsonIgnore
  User user;

  String text;

  Date createDate = new Date();

}
