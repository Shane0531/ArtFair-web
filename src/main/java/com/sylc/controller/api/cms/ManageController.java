package com.sylc.controller.api.cms;

import com.sylc.utils.FileManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedInputStream;
import java.io.InputStream;

@Controller
@Slf4j
@RequestMapping("/api")
public class ManageController {
  public enum FileCategory {
    event, artist, banner, location
  }

  @Autowired
  FileManager fileManager;


  @RequestMapping(value = "/manage/file/{category}", method = RequestMethod.GET)
  @ResponseBody
  public Object fileList(@PathVariable FileCategory category,
                         @RequestParam("path") String dirPath) {
    dirPath = getPath(category, dirPath);
    return fileManager.list(dirPath, true);
  }

  @RequestMapping(value = "/manage/file/{category}/selector", method = RequestMethod.GET)
  public Object fileListView(@PathVariable FileCategory category,
                             @RequestParam("path") String dirPath) {
    ModelAndView mv = new ModelAndView("cms/resource/fileSelector");
    mv.addObject("imgList", fileList(category, dirPath));
    mv.addObject("category", category.toString());
    return mv;
  }

  @RequestMapping(value = "/manage/file/{category}", method = RequestMethod.POST)
  @ResponseBody
  public String fileUpload(@PathVariable FileCategory category,
                                 @RequestParam("path") String dirPath,
                                 StandardMultipartHttpServletRequest request) {
    dirPath = getPath(category, dirPath);
    fileManager.makeDirectory(dirPath);
    int count = 0;
    try (InputStream is = new BufferedInputStream(request.getFile("file").getInputStream())) {
      fileManager.upload(dirPath + "/" + request.getFile("file").getOriginalFilename(), is);
    } catch (Exception e) {
      log.error("파일 업로드 실패", e);
    }

    return "OK!";
  }

  @RequestMapping(value = "/manage/file/{category}", method = RequestMethod.DELETE)
  @ResponseBody
  public Object fileDelete(@PathVariable FileCategory category, @RequestParam String path) {
    if (path.startsWith("/files/" + category + "/")) {
      path = path.replaceFirst("/files/" + category + "/", "");
    }
    try {
      if (fileManager.delete(getPath(category, path))) {
        return ResponseEntity.ok().build();
      } else {
        return ResponseEntity.status(500).build();
      }
    } catch (Exception e) {
      log.error("파일삭제 실패", e);
      return ResponseEntity.status(500).build();
    }

  }

  public String getPath(FileCategory category, String path) {
    //보안을 위해
    return String.format("%s/%s", category, path.replaceAll("\\.\\.", ""));

  }
}
