package demo.ex03.pyrmont;

import demo.ex03.pyrmont.connector.http.HttpRequest;
import demo.ex03.pyrmont.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
