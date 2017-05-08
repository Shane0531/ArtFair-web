package com.sylc.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ItemArticle extends Article{
  int price;
}
