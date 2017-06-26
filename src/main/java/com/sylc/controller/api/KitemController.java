package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import com.sylc.model.KnowledgeArticle;
import com.sylc.model.KnowledgeComment;
import com.sylc.model.User;
import com.sylc.repo.KnowledgeArticleRepo;
import com.sylc.repo.KnowledgeCommentRepo;
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

@Controller
@Slf4j
public class KitemController extends BaseController {

  @Autowired
  KnowledgeArticleRepo knowledgeArticleRepo;

  @Autowired
  KnowledgeCommentRepo knowledgeCommentRepo;

  @Autowired
  UserRepo userRepo;

  @Autowired
  FileManager fileManager;

  @RequestMapping("/kitem")
  public String kitemListView(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    List<KnowledgeArticle> itemArticleList = knowledgeArticleRepo.findAllByOrderByIdxDesc();
    model.addAttribute("itemList",itemArticleList);
    return "app/kitem/list";
  }

  @RequestMapping("/kitem/{idx}")
  public String kitemView(@PathVariable int idx, HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    KnowledgeArticle item = knowledgeArticleRepo.findOne(idx);
    List<KnowledgeComment> comments = knowledgeCommentRepo.findAllByArticleIdxOrderByIdxDesc(idx);
    model.addAttribute("sessionContext",sessionContext);
    model.addAttribute("item",item);
    model.addAttribute("comments",comments);
    model.addAttribute("commentSize",comments.size());
    return "app/kitem/view";
  }

  @RequestMapping("/kitem/add")
  public String kitemAddView(HttpServletRequest request, Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/kitem/edit";
  }

  @PostMapping("/kitem/add")
  @ResponseBody
  public Object kitemAdd(HttpServletRequest request, @RequestParam String title,
                         @RequestParam  String text, StandardMultipartHttpServletRequest smRequest) {
    KnowledgeArticle article = new KnowledgeArticle();
    SessionContext sessionContext = getSessionContext(request);
    article.setTitle(title);
    article.setText(text);
    User user = userRepo.findOne(sessionContext.getIdx());
    article.setUser(user);

    //이미지 올리기
    String filename = smRequest.getFile("file").getOriginalFilename();
    if(!filename.equals("")) {
      fileManager.makeDirectory(getPath("kitem"));
      try (InputStream is = new BufferedInputStream(smRequest.getFile("file").getInputStream())) {
        fileManager.upload(getPath("kitem") + "/" + smRequest.getFile("file").getOriginalFilename(), is);
        article.setImageUrl("/files/"+getPath("kitem") + "/" + smRequest.getFile("file").getOriginalFilename());
      } catch (Exception e) {
        log.error("파일 업로드 실패", e);

      }
    }

    knowledgeArticleRepo.save(article);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("result", "Y");
    return resultMap;
  }

  @PostMapping("/kitem/{idx}/comment/add")
  @ResponseBody
  public Object kitemCommentAdd(HttpServletRequest request, @RequestParam String commentText,
                                @PathVariable int idx) {
    SessionContext sessionContext = getSessionContext(request);
    if (sessionContext.getIsLogin()) {
      return "redirect:/";
    }
    KnowledgeArticle article = knowledgeArticleRepo.findOne(idx);
    User user = userRepo.findOne(sessionContext.getIdx());
    KnowledgeComment comment = new KnowledgeComment();
    comment.setUser(user);
    comment.setText(commentText);
    comment.setArticle(article);

    knowledgeCommentRepo.save(comment);


    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("result", "Y");
    return resultMap;
  }
}
