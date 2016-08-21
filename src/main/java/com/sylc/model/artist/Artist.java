package com.sylc.model.artist;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Artist {
  @Id
  @GeneratedValue
  int idx;

  String name;
}
