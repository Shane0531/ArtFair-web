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

  Date createdDate = new Date();

  public String getUserName() {
    return user.getName();
  }
}