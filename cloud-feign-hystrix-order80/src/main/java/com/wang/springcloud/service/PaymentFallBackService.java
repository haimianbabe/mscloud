package com.wang.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentFallBackService implements OrderService{
    @Override
    public String peymentOk(Integer id) {
        return "调用peymentOk失败";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "调用paymentTimeOut失败";
    }
}
