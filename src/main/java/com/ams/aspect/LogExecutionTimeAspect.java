package com.ams.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {

    Logger logger = LogManager.getLogger(LogExecutionTimeAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        var result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Execution time of for Class[{}] -> Method[{}] is: {} millis", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), (end - start));
        return result;
    }
}
