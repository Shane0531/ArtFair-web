package com.sylc.controller.api;

import com.sylc.common.SessionContext;
import com.sylc.model.ItemArticle;
import com.sylc.model.KnowledgeArticle;
import com.sylc.repo.ItemArticleRepo;
import com.sylc.repo.KnowledgeArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {

  @Autowired
  ItemArticleRepo itemArticleRepo;

  @Autowired
  KnowledgeArticleRepo knowledgeArticleRepo;

  @RequestMapping("/")
  public String index(HttpServletRequest request,Model model) {
    SessionContext sessionContext = getSessionContext(request);
    List<ItemArticle> itemArticleList = itemArticleRepo.findAllByOrderByIdxDescLimit8();
    List<KnowledgeArticle> knowledgeArticleList = knowledgeArticleRepo.findAllByOrderByIdxDescLimit8();
    model.addAttribute("sessionContext",sessionContext);
    model.addAttribute("iitemList",itemArticleList);
    model.addAttribute("kitemList",knowledgeArticleList);
    return "app/index";
  }

  @RequestMapping("/contact")
  public String contact(HttpServletRequest request,Model model) {
    SessionContext sessionContext = getSessionContext(request);
    model.addAttribute("sessionContext",sessionContext);
    return "app/contact";
  }

  @RequestMapping(value = "/sendemail", method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public Object sendEmail(@RequestParam String name, String email, String phone, String companyName, String subject, String message) {
    String to = "tjdghks0531@gmail.com";

    // Assuming you are sending email from localhost
    String host = "localhost";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty("mail.smtp.host", host);

    // Get the default Session object.
    Session session = Session.getDefaultInstance(properties);

    try {
      // Create a default MimeMessage object.
      MimeMessage mimeMessage = new MimeMessage(session);

      // Set From: header field of the header.
      mimeMessage.setFrom(new InternetAddress(email));

      // Set To: header field of the header.
      mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      mimeMessage.setSubject(subject);

      // Now set the actual message
      String text = "name : " + name + " phone : " + phone + "companyName" + companyName + "message : " + message;
      mimeMessage.setText(text);

      // Send message
      Transport.send(mimeMessage);
      return "{\"type\":\"success\" , \"message\" : \"Thank you for contact us. As early as possible  we will contact you \"}";
    }catch (MessagingException mex) {
      mex.printStackTrace();
    }

    return null;
  }

}
