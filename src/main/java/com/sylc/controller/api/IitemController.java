package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public class IitemController extends BaseController {

  @RequestMapping("/iitem")
  public String iitem(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/iitem/list";
  }

  @RequestMapping("/iitem/{idx}")
  public String iitemView(@PathVariable int idx, HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/iitem/view";
  }

}
