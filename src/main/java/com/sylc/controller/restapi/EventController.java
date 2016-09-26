package com.sylc.controller.restapi;

import com.sylc.model.event.Event;
import com.sylc.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
  @Autowired
  EventRepo eventRepo;

  @RequestMapping("/")
  public List<Event> findAllEvent() {
    List<Event> events = eventRepo.findAll();
    return events;
  }

}
