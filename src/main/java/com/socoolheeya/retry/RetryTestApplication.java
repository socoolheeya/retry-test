package com.socoolheeya.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryTestApplication.class, args);
    }

}
