package com.wang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MyLB implements LoadBanlencer{

    AtomicInteger atomicInteger = new AtomicInteger();

    public final int getAndIncrement(){
        int cur = 0;
        int next = 0;
        do{
            cur = this.atomicInteger.get();
            next = cur >= 2147483647 ? 0 : cur+1 ;
        }while (!this.atomicInteger.compareAndSet(cur,next));
        System.out.println("*****next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {

        int index = getAndIncrement()%serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
