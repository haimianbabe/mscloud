package com.wang.springcloud;

import com.wang.myrule.MyRobbinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRobbinRule.class)
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp80 {

    public static void main(String[] args) {
        SpringApplication.run(MainApp80.class,args);
    }
}
