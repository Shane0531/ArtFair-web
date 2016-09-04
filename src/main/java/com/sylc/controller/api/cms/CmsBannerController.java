package com.sylc.controller.api.cms;

import com.sylc.model.Banner;
import com.sylc.repository.BannerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/banners")
public class CmsBannerController {
  @Autowired
  BannerRepo bannerRepo;

  @RequestMapping("/")
  public String listBannerView(Model model) {
    List<Banner> banners = bannerRepo.findAll();
    List<Banner> bannerList = banners.stream().sorted((o1, o2) -> (o1.getOrderNum() > o2.getOrderNum() ? 1 : -1)).collect(Collectors.toList());
    model.addAttribute("bannerList", bannerList);
    return "cms/banner/list";
  }

  @RequestMapping("/add")
  public String addBanner(@ModelAttribute Banner banner) {
    bannerRepo.save(banner);
    return "redirect:/admin/banners/";
  }

  @RequestMapping(value="/delete", method = RequestMethod.POST)
  @ResponseBody
  public String deleteBanner(@RequestParam int idx) {
    bannerRepo.delete(idx);
    return "{\"msg\":\"OK\"}";
  }

  @RequestMapping("/{idx}")
  public String editBannerView(@PathVariable int idx, Model model) {
    Banner banner = bannerRepo.findOne(idx);
    model.addAttribute("item", banner);
    return "cms/banner/edit";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  @Transactional
  public String editBanner(@ModelAttribute Banner item) {
    Banner banner = bannerRepo.findOne(item.getIdx());
    banner.setName(item.getName());
    banner.setWebImageUrl(item.getWebImageUrl());
    banner.setMobileImageUrl(item.getMobileImageUrl());
    banner.setOrderNum(item.getOrderNum());

    return "redirect:/admin/banners/";
  }
}
