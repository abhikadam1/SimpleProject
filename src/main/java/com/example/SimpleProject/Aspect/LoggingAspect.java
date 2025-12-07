package com.example.SimpleProject.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.Timestamp;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution (public * com.example.SimpleProject.Controller.ProductController.getProducts())")
//    public void log() {
////        System.out.println(new Timestamp(System.currentTimeMillis()));
////        System.out.println(message);
//        System.out.println("Logging Aspect: ");
//    }

//    @Before("execution(* com.example.SimpleProject.Controller.*.*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("➡️ Before method: " + joinPoint.getSignature().getName());
//    }

}
