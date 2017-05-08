package com.sylc.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue
  int idx;

  String name;

  String id;

  String passwd;

  Date createdDate = new Date();

  String imageUrl;

  //학번
  String studentNumber;

}
