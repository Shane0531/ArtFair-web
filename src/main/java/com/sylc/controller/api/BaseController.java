package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import com.sylc.model.User;
import groovy.util.logging.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class BaseController {

  protected SessionContext getSessionContext(HttpServletRequest request) {
    SessionContext sessionContext = (SessionContext)request.getSession().getAttribute("sessionContext");
    if( sessionContext == null ) {
      sessionContext = new SessionContext(new User());
    }
    return sessionContext;
  }

}
