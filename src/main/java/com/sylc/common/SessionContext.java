package com.sylc.common;

import lombok.Getter;

import java.io.Serializable;

/**
 * 세션에 보관할 정보를 담을 객체
 */
@SuppressWarnings("serial")
@Getter
final public class SessionContext implements Serializable {
  private int idx = 0;  // 일련번호
  private String id = ""; // 아이디
  private String name = ""; // 이름
  /**
   * 생성자
   * @param manager 관리자 정보
   */
//  public SessionContext(Manager manager) {
//    idx = manager.getIdx();
//    id = manager.getId();
//    name = manager.getName();
//  }

  /**
   * 로그인 여부 체크
   * @return 로그인 여부 (true : 로그인 상태, false : 로그아웃 상태)
   */
  public boolean getIsLogin() {
    if( idx > 0 && !id.isEmpty() ) {
      return true;
    } else {
      return false;
    }
  }
}
