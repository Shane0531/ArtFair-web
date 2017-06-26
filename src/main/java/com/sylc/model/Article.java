package com.sylc.model;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@MappedSuperclass
public class Article {
  @Id
  @GeneratedValue
  int idx;

  String title;

  @JoinColumn(name = "userIdx")
  @ManyToOne
  User user;

  Date createdDate = new Date();

  String text;

  String imageUrl;

  String sort;

  public String getUserName() {
    return user.getName();
  }

  public String getCreatedDate() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    return df.format(createdDate);
  }

  public Date getFullDate() {
    return createdDate;
  }

}
