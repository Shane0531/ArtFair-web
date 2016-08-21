package com.sylc.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum Language {
  ko("ko","한국어"), en("en","중국어");

  @Getter
  public String description;
  @Getter
  public String code;

  Language(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public static List<Language> getLanguageList(){
    return Arrays.asList(Language.values());
  }

}
