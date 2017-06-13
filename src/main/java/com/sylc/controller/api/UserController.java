package com.sylc.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/login")
  public String viewLogin() {
    return "app/user/login";
  }

  @GetMapping("/signup")
  public String viewSingUp() {
    return "app/user/signup";
  }
}
