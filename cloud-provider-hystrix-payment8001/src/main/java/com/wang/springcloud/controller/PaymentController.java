package com.wang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@DefaultProperties(defaultFallback = "defaultFallBack")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        return paymentService.paymentOk(id);
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand
    public String paymentTimeOut(@PathVariable("id") Integer id){
        return paymentService.paymentTimeOut(id);
    }

    public String defaultFallBack(){
        return "服务无法请求，请重试";
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
