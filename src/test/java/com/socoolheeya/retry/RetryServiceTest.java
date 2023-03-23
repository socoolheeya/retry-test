package com.socoolheeya.retry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RetryServiceTest {

    @Autowired
    private RetryService retryService;
    @Test
    void retry() {
        String msg = retryService.retry("123123");
        System.out.println("##### msg : " + msg);


    }

    @Test
    void getRecover() {
    }
}