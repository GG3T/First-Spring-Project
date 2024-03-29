package org.generation.brazil.artemis;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ArtemisApplication {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(ArtemisApplication.class, args);

  }

}

