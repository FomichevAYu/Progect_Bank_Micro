package com.bank.account.utill.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * end-to-end logging using aspects
 */

@Component
@Aspect
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before("execution(* com.bank.account.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("Method {}() of {} started", method, className);
    }

    @AfterReturning(value = "execution(* com.bank.account.*.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("Method {}() of {} finished with result {}", method, className, result);
    }

    @AfterThrowing(value = "execution(* com.bank.account.*.*.*(..))", throwing = "exception")
    public void logAfterException(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.error("Method {}() of {} threw exception {}", method, className, exception.getMessage());
    }
}
