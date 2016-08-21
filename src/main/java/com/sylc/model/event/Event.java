package com.sylc.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sylc.model.enums.Language;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class Event {
  @Id
  @GeneratedValue
  int idx;

  /**
   * 관리 상 이름
   */
  String name;

  String imageUrl;

  @Temporal(TemporalType.TIMESTAMP)
  Date writeDate = new Date();

  /**
   * 언어별 이벤트 정보
   */
  @MapKeyColumn(name = "lang", nullable = true)
  @JoinColumn(name = "eventIdx")
  @OneToMany(cascade = {CascadeType.ALL})
  @JsonIgnore
  Map<String, EventInfo> info = new HashMap<>();

  public void putInfo(Language lang, EventInfo info) {
    this.info.put(lang.code, info);
  }

  public Event(){}

  public Event(String name, String imageUrl) {
    this.name = name;
    this.imageUrl = imageUrl;
    for(Language lang : Language.getLanguageList()) {
      this.putInfo(lang, new EventInfo());
    }
  }
}
