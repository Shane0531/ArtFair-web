package com.sylc.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class FileManager {

  @Value("${path.upload_dir}")
  protected String uploadDir;

  protected String getUrlPathPrefix() {
    return "/files/";
  }

  protected String getFilePathPrefix() {
    return uploadDir;
  }

  protected String toPath(String url){
    String urlPrefix = getUrlPathPrefix();
    String filePrefix = getFilePathPrefix();
    if(url.startsWith(urlPrefix)){
      url = url.replaceFirst(urlPrefix, "");
    }
    if(url.startsWith(filePrefix))
      return url;
    return  filePrefix + url;
  }

  public FileInfo getFileInfo(String filePath) {
    File f = new File(toPath(filePath));
    if (!f.exists()) return null;
    String path = getUrlPathPrefix() + f.getPath().replace(getFilePathPrefix(), "");
    return new FileInfo(f.isDirectory(), path, f.getName(), f);
  }

  public List<FileInfo> list(String dirPath, boolean fileOnly) {
    File dir = new File(getFilePathPrefix() + dirPath);
    File[] files = dir.listFiles();
    if (!dir.exists() || !dir.isDirectory() || files == null) {
      return Collections.emptyList();
    }
    List<FileInfo> list = new ArrayList<>();

    Arrays.sort(files);

    for (File f : files) {
      if (f.getName().startsWith(".")) continue;
      FileInfo fileInfo = getFileInfo(f.getPath());
      if (fileInfo == null || (fileOnly && fileInfo.isDirectory)) continue;
      list.add(fileInfo);
    }
    return list;

  }

  public String readText(String filePath) {
    File f = new File(toPath(filePath));
    if (!f.exists()) throw new RuntimeException(new IOException("there is no file : " + filePath));
    try (InputStream is = new BufferedInputStream(new FileInputStream(f))) {
      return org.apache.commons.io.IOUtils.toString(is);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public boolean upload(String filePath, InputStream inputStream) {
    File upload = new File(getFilePathPrefix() + filePath);
    try (OutputStream os = new BufferedOutputStream(new FileOutputStream(upload))) {
      FileCopyUtils.copy(inputStream, os);
    } catch (Exception e) {
      log.error("파일 업로드 실패", e);
      return false;
    }
    return true;
  }

  public boolean upload(String filePath, File file) {
    File upload = new File(getFilePathPrefix() + filePath);
    try (InputStream is = new FileInputStream(file);
         OutputStream os = new FileOutputStream(upload)) {
      IOUtils.copy(is, os);
    } catch (Exception e) {
      log.error("파일 업로드 실패", e);
      return false;
    }
    return true;
  }

  public boolean delete(String path) {
    File targetFile = new File(toPath(path));
    return targetFile.exists() && targetFile.isFile() && targetFile.delete();
  }

  public boolean makeDirectory(String dirPath) {
    File dir = new File(getFilePathPrefix() + dirPath);
    if (dir.exists() && dir.isFile()) {
      throw new IllegalArgumentException("잘못된 path");
    }
    if (!dir.exists()) {
      if (!dir.mkdirs()) {
        log.error("폴더 생성실패");
        return false;
      }
    }
    return true;
  }
}
