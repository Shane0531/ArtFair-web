package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import com.sylc.model.User;
import com.sylc.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserController extends BaseController {

  @Autowired
  UserRepo userRepo;

  @GetMapping("/login")
  public String viewLogin(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    if (sessionContext.getIsLogin()) {
      return "redirect:/";
    }
    return "app/user/login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  @GetMapping("/signup")
  public String viewSingUp(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    if (sessionContext.getIsLogin()) {
      return "redirect:/";
    }
    return "app/user/signup";
  }

  @RequestMapping("/user/std/check")
  @ResponseBody
  public Object checkStd(@RequestParam int std) {
    User user = userRepo.findOneByStudentNumber(std);
    Map<String, Object> resultMap = new HashMap<>();
    if(user == null)
      resultMap.put("result", "Y");
    else
      resultMap.put("result", "N");
    return resultMap;
  }

  @RequestMapping(value="/signup", method=RequestMethod.POST)
  @ResponseBody
  public Object signUpUser(@RequestParam String id, @RequestParam String nickName, @RequestParam String passwd,
                           @RequestParam int stdno) {
    User user = new User(id,nickName,passwd,stdno);

    userRepo.save(user);

    Map<String, Object> resultMap = new HashMap<>();
    log.info("SIGNUP name: {}, id : {}", nickName,id);
    resultMap.put("result", "Y");
    return resultMap;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public Object loginPost(HttpServletRequest request, @RequestParam String id, @RequestParam String passwd) {
    SessionContext sessionContext = getSessionContext(request);

    User user = userRepo.selectLogin(id,passwd);
    Map<String, Object> resultMap = new HashMap<>();
    if(user != null) {
      request.getSession().setAttribute("sessionContext", new SessionContext(user));
      resultMap.put("result", "Y");
      return resultMap;
    } else {
      resultMap.put("result", "N");
      return resultMap;
    }
  }
}
