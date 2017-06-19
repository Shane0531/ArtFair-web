package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public class KitemController extends BaseController {

  @RequestMapping("/kitem")
  public String kitem(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/kitem/list";
  }

  @RequestMapping("/kitem/{idx}")
  public String kitemView(@PathVariable int idx, HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/kitem/view";
  }

}
