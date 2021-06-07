package com.github.atulkaushal.fetch.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class FetchRewardsApplication.
 *
 * @author Atul
 */
@SpringBootApplication
@RestController
public class FetchRewardsApplication {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(FetchRewardsApplication.class, args);
  }

  /**
   * Welcome message.
   *
   * @return the string
   */
  @GetMapping("/")
  public String welcomeMessage() {
    return "Welcome to Fetch Rewards";
  }
}
