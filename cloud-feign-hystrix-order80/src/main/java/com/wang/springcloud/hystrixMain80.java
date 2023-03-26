package com.wang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class hystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(hystrixMain80.class,args);
    }
}