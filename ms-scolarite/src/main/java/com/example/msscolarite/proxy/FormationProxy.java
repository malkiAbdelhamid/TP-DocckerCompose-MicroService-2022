package com.example.msscolarite.proxy;


import com.example.msscolarite.model.Formation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation")
@LoadBalancerClient(name="ms-formation",configuration = LBConfiguration.class)
public interface FormationProxy {
    @GetMapping("/formations/{id}")
    @CircuitBreaker(name="fall1", fallbackMethod = "fallbackFormation")
    Formation getFormation(@PathVariable("id") Long idf);

    default Formation fallbackFormation(Throwable throwable) {

        return new Formation("php",0) ;
    }
}