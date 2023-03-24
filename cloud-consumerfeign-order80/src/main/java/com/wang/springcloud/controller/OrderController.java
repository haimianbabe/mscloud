package com.wang.springcloud.controller;

import com.wang.springcloud.entities.CommonResult;
import com.wang.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return orderService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String getTimeout(){
        return orderService.getTimeOut();
    }
}
