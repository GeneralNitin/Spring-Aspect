package com.generalnitin.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Aspect
public class LogAspect {
    @Around("@annotation(customAnnotation) && execution(* *(..))")
    public Object log(ProceedingJoinPoint joinPoint, CustomAnnotation customAnnotation) throws Throwable {
        String metricName = customAnnotation.metricName() != null ? customAnnotation.metricName() : "method.timer";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(metricName);
        try {
            return joinPoint.proceed();
        }
        finally {
            stopWatch.stop();
            System.out.println(stopWatch.lastTaskInfo().getTaskName() + " " + stopWatch.getTotalTime(TimeUnit.MILLISECONDS));
        }
    }
}
