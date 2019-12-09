package com.learn.spl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SplApplication {

    private static final Logger logger = LoggerFactory.getLogger(SplApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SplApplication.class, args);
    }

}
