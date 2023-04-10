package com.amazing.intercom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amazing.intercom.dao")
public class IntercomApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntercomApplication.class, args);
    }

}
