package com.ams.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;

@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        var result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time of method("+joinPoint.getSignature().getName()+") is: "+(end - start)+" millis");
        return result;
    }
}
