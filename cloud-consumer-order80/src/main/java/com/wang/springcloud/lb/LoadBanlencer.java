package com.wang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBanlencer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
