package com.example;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class ReadFromHdfsDemo {

  private final String hdfsRootUrl;

  private final Configuration configuration;

  public ReadFromHdfsDemo(final String hdfsRootUrl, final Configuration cOnfiguration) {
    this.hdfsRootUrl = hdfsRootUrl;
    this.configuration = cOnfiguration;
  }

  public void readAndPrint(final String filePath) throws IOException {
    final String path = hdfsRootUrl + filePath;
    FileSystem fileSystem = FileSystem.get(URI.create(path), configuration);
    FSDataInputStream in = fileSystem.open(new Path(path));
    String out = IOUtils.toString(in, StandardCharsets.UTF_8);
    System.out.println(out);
    in.close();
  }
}
