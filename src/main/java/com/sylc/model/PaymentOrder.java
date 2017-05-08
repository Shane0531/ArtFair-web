package com.sylc.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PaymentOrder {
  @Id
  @GeneratedValue
  int idx;

  @JoinColumn(name = "userIdx")
  @ManyToOne
  User user;

  @JoinColumn(name = "articleIdx")
  @ManyToOne
  ItemArticle article;

  String email = "";

  String phone = "";

  // 배송시사용할 이름
  String name = "";

  long amountOrder = 0;

  String address = "";
}
