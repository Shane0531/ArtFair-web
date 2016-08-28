package com.sylc.lib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Properties Manager - 프로퍼티 관리
 */
@Slf4j
public class PropManager {
  /** 프로퍼티를 저장 할 멤버 변수 */
  private static Properties m_oProperties = null;

  /**
   * 생성자
   */
  private PropManager() {}

  /**
   * properties 파일 load
   * @param szFullPathName properties 파일의 전체 경로
   * @return 초기화 성공 여부 (true : 성공, fail : 실패)
   */
  public static boolean init(ResourceLoader resourceLoader, List<String> szFullPathName) {
    if( m_oProperties == null && !szFullPathName.isEmpty() ) {
      try {

        m_oProperties = new Properties();
        for(String path : szFullPathName) {
          File f = new File(path);
          if(f.exists())
            m_oProperties.load(new FileInputStream(path));
          else {
            Resource resource = resourceLoader.getResource("classpath:/" + path);
            if(resource.exists())
              m_oProperties.load(resource.getInputStream());
          }
          log.info("{} loaded", path);
        }
      } catch(Exception e) {
        m_oProperties = null;
        e.printStackTrace();
      }
    }
    if( m_oProperties == null ) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Properties Getter
   * @return Properties Object
   */
  public static Properties getProperties() {
    return m_oProperties;
  }

  /**
   * property key에 해당하는 value 값을 구함
   * @param szKey property 키
   * @return property value
   */
  public static String get(String szKey) {
    if( m_oProperties == null ) {
      return "ERROR : Properties Not Initial";
    } else {
      return m_oProperties.getProperty(szKey);
    }
  }
}
