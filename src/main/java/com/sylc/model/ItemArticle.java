package com.sylc.model;

import lombok.Data;

import javax.persistence.Entity;
import java.text.DecimalFormat;

@Data
@Entity
public class ItemArticle extends Article{
  int price;

  public String getPrice(){
    DecimalFormat df = new DecimalFormat("###,###,###");
    return df.format(price)+"원";
  }
}
