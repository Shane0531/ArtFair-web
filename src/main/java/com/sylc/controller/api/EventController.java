package com.sylc.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

  @GetMapping("/events")
  public String viewEvent() {
    return "app/event/view";
  }
}
