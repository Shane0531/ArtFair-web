package com.sylc.controller.restapi;

import com.sylc.model.Banner;
import com.sylc.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/banners")
public class BannerController {
  @Autowired
  BannerRepo bannerRepo;

  @RequestMapping("/")
  public List<Banner> findAllBanner(){
    List<Banner> banners = bannerRepo.findAll();
    List<Banner> bannerList = banners.stream().sorted((o1, o2) -> (o1.getOrderNum() > o2.getOrderNum() ? 1 : -1)).collect(Collectors.toList());
    return bannerList;
  }
}
