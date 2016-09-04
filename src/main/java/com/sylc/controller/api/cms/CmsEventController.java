package com.sylc.controller.api.cms;

import com.sylc.model.event.Event;
import com.sylc.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/events")
public class CmsEventController {
  @Autowired
  EventRepo eventRepo;

  @RequestMapping("/")
  public String listEventView(Model model) {
    List<Event> eventList = eventRepo.findAll();
    model.addAttribute("eventList", eventList);
    return "cms/event/list";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String addEvent(@RequestParam String name, @RequestParam String imageUrl) {
    Event event = new Event(name,imageUrl);
    eventRepo.save(event);
    return "redirect:/admin/events/";
  }

  @RequestMapping(value="/delete", method = RequestMethod.POST)
  @ResponseBody
  public String deleteEvent(@RequestParam int idx) {
    eventRepo.delete(idx);
    return "{\"msg\":\"OK\"}";
  }
}
