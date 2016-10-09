package com.sylc.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController {

  @GetMapping("/artists")
  public String viewArtist(){
    return "app/artist/view";
  }

}
