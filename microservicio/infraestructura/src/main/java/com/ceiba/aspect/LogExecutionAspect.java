package com.ceiba.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.security.Signature;

@Aspect
@Component
public class LogExecutionAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        LOGGER.info(getExecutionTime((Signature) joinPoint.getSignature(), executionTime));

        return proceed;
    }

    private String getExecutionTime(Signature signature, long executionTime)
    {
        return signature + " executed in " + executionTime + "ms";
    }
}