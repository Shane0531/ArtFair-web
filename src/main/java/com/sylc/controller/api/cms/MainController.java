package com.sylc.controller.api.cms;

import com.sylc.common.SessionContext;
import com.sylc.model.Manager;
import com.sylc.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class MainController {
  @Autowired
  ManagerRepo managerRepo;

  @RequestMapping(value = "/login")
  public String index() {
    return "cms/login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginCheck(HttpServletRequest request, @RequestParam String id, @RequestParam String password) {
    Manager manager = managerRepo.selectLogin(id, password);

    if( manager != null) {
      // Set Session
      request.getSession().setAttribute("sessionContext", new SessionContext(manager));
      return "redirect:main";
    } else {
      return "cms/login";
    }
  }

  @RequestMapping(value = "/main")
  public String main() { return "cms/main";}

  // 로그아웃
  @RequestMapping(value="/logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate();
    return "redirect:login";
  }

}
