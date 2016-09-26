package com.sylc.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping(value = {"/", "/events", "/artists", "/about", "/location"})
  public String index() {
    return "index";
  }

}
