package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import com.sylc.model.ItemArticle;
import com.sylc.model.ItemComment;
import com.sylc.model.User;
import com.sylc.repo.ItemArticleRepo;
import com.sylc.repo.ItemCommentRepo;
import com.sylc.repo.UserRepo;
import com.sylc.utils.FileManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class IitemController extends BaseController {

  @Autowired
  ItemArticleRepo itemArticleRepo;

  @Autowired
  ItemCommentRepo itemCommentRepo;

  @Autowired
  UserRepo userRepo;

  @Autowired
  FileManager fileManager;


  @RequestMapping("/iitem")
  public String iitemListView(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    List<ItemArticle> itemArticleList = itemArticleRepo.findAllByOrderByIdxDesc();
    model.addAttribute("sessionContext",sessionContext);
    model.addAttribute("itemList",itemArticleList);
    return "app/iitem/list";
  }

  @RequestMapping("/iitem/{idx}")
  public String iitemView(@PathVariable int idx, HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    ItemArticle item = itemArticleRepo.findOne(idx);
    List<ItemComment> comments = itemCommentRepo.findAllByArticleIdxOrderByIdxDesc(idx);
    model.addAttribute("sessionContext",sessionContext);
    model.addAttribute("item",item);
    model.addAttribute("comments",comments);
    model.addAttribute("commentSize",comments.size());
    return "app/iitem/view";
  }

  @RequestMapping("/iitem/add")
  public String iitemAddView(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/iitem/edit";
  }

  @PostMapping("/iitem/add")
  @ResponseBody
  public Object iitemAdd(HttpServletRequest request, @RequestParam String title, @RequestParam int price,
                         @RequestParam  String text, StandardMultipartHttpServletRequest smRequest) {
    ItemArticle article = new ItemArticle();
    SessionContext sessionContext = getSessionContext(request);
    article.setTitle(title);
    article.setText(text);
    article.setPrice(price);
    User user = userRepo.findOne(sessionContext.getIdx());
    article.setUser(user);

    //이미지 올리기
    String filename = smRequest.getFile("file").getOriginalFilename();
    if(!filename.equals("")) {
      fileManager.makeDirectory(getPath("iitem"));
      try (InputStream is = new BufferedInputStream(smRequest.getFile("file").getInputStream())) {
        fileManager.upload(getPath("iitem") + "/" + smRequest.getFile("file").getOriginalFilename(), is);
        article.setImageUrl("/files/"+getPath("iitem") + "/" + smRequest.getFile("file").getOriginalFilename());
      } catch (Exception e) {
        log.error("파일 업로드 실패", e);

      }
    }

    itemArticleRepo.save(article);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("result", "Y");
    return resultMap;
  }

  @PostMapping("/iitem/{idx}/comment/add")
  @ResponseBody
  public Object iitemCommentAdd(HttpServletRequest request, @RequestParam String commentText,
                                @PathVariable int idx) {
    SessionContext sessionContext = getSessionContext(request);
    if (sessionContext.getIsLogin()) {
      return "redirect:/";
    }
    ItemArticle article = itemArticleRepo.findOne(idx);
    User user = userRepo.findOne(sessionContext.getIdx());
    ItemComment comment = new ItemComment();
    comment.setUser(user);
    comment.setText(commentText);
    comment.setArticle(article);

    itemCommentRepo.save(comment);


    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("result", "Y");
    return resultMap;
  }
}
