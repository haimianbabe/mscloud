package com.wang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallBackService.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    String peymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    String paymentTimeOut(@PathVariable("id") Integer id);
}
