package com.record.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    try {
      SpringApplication.run(Application.class, args);
    }catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
  }
}
