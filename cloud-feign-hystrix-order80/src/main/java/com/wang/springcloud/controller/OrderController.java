package com.wang.springcloud.controller;

import com.wang.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        return orderService.peymentOk(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        return orderService.paymentTimeOut(id);
    }
}
