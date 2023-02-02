package com.example;

import java.util.Properties;
import org.apache.hadoop.conf.Configuration;

public class App {

  public static void main(String[] args) throws Exception {
    final String propertiesPath = "read.properties";
    final Properties properties = new Properties();
    properties.load(
        Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesPath));
    final String hdfsRootUrl = properties.getProperty("hdfsRootUrl");
    final String filePath = properties.getProperty("filePath");
    final Configuration configuration = new Configuration();
    final ReadFromHdfsDemo demo = new ReadFromHdfsDemo(hdfsRootUrl, configuration);
    demo.readAndPrint(filePath);
  }
}
