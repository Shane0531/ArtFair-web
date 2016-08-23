package com.sylc.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Banner {
  @Id
  @GeneratedValue
  int idx;

  /**
   * 관리상 이름
   */
  String name;

  String webImageUrl;

  String mobileImageUrl;

  int orderNum;

}
