package com.socoolheeya.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
public class RetryService {

    @Retryable(retryFor = NoSuchElementException.class,
            exceptionExpression = "message.contains('error is terrible')",
            noRetryFor = {NullPointerException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000, maxDelay = 5000),
            recover = "getRecover"
    )
    public String retry(String message) {
        log.info("#### plz~~~~~~~~");
        if("123".equals(message)) {
            log.warn("#### retry message : {}", message);
        } else {
            throw new NoSuchElementException("#### error is terrible !!!!!!");
        }
        return message;
    }

    @Recover
    public String getRecover(NoSuchElementException e, String message) {
        log.error("###### getRecover error {}", e.getMessage());
        log.info("####### getRecover message : {}", message);

        return message;
    }
}
