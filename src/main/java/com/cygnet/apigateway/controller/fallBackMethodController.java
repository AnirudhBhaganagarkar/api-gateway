package com.cygnet.apigateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallBackMethodController
{

    @GetMapping("/usersServiceFallBackMethod")
    @CircuitBreaker(name = "USERS-SERVICE", fallbackMethod = "userServiceFallBackMethod")
    public String userServiceFallBackMethod()
    {
        return "User Service taking Longers than Expected" +
                "Please try again ";
    }

    @GetMapping("/departementServiceFallBackMethod")
    @CircuitBreaker(name = "DEPARTEMENT-SERVICE", fallbackMethod = "departementServiceFallBackMethod")
    public String departementServiceFallBackMethod()
    {
        return "Departement Service taking Longers than Expected" +
                "Please try again ";
    }
}
