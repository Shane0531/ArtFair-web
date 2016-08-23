package com.sylc.controller.api.cms;

import com.sylc.model.Banner;
import com.sylc.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/banners")
public class CmsBannerController {
  @Autowired
  BannerRepo bannerRepo;

  @RequestMapping("/")
  public String listBanner(Model model) {
    List<Banner> banners = bannerRepo.findAll();
    List<Banner> bannerList = banners.stream().sorted((o1, o2) -> (o1.getOrderNum() > o2.getOrderNum() ? 1 : -1)).collect(Collectors.toList());
    model.addAttribute("bannerList", bannerList);
    return "cms/banner/list";

  }
}
