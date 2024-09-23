package com.bankapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //advice + pointcut
public class LoggingAspect {

	private Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution( * com.bankapp.service..*Impl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String targetMethodName=pjp.getSignature().getName();
		long start= System.currentTimeMillis();
		
		Object result= pjp.proceed();
		
		long end=System.currentTimeMillis();
		logger.info("time taken to exe "+targetMethodName+" method is "+(end-start)+" ms");
		return result;
	}
}
