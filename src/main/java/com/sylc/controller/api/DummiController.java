package com.sylc.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummiController {

  @RequestMapping("/dummi")
  @ResponseBody
  public Object dummi() {
    return "{\"result\":\"dummi\"}";
  }
}
