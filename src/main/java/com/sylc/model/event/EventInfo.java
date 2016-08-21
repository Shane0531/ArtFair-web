package com.sylc.model.event;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class EventInfo {
  @Id
  @GeneratedValue
  int idx;

  String lang;

  String name;

  String description;

}
