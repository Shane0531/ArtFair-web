package com.sylc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileInfo {
  public String name;
  public String path;
  public boolean isDirectory;
  private File file;

  public FileInfo(boolean isDir, String path, String name, File file) {
    this.name = name;
    this.path = path;
    this.isDirectory = isDir;
    this.file = file;
  }

  public String getUrl(){
    return path;
  }

  public InputStream getInputStream() {
    try {
      return new FileInputStream(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public long getFileSize() {
    return file.length();
  }

  public boolean isInformationOnly() {
    return file == null;
  }
}
