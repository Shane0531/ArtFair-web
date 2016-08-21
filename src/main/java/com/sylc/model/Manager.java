package com.sylc.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Manager {
  @Id
  @GeneratedValue
  int idx;

  String id;

  String password;

  String name;

}
