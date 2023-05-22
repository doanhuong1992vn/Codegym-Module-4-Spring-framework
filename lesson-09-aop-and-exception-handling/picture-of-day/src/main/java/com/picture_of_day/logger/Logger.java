package com.picture_of_day.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.picture_of_day.controller.MainController.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        System.out.printf("Exist any dirty words from: %s.%s(): %s", className, method, e.getMessage());
    }
}