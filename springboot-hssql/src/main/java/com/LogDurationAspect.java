package com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogDurationAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogDurationAspect.class);

	// @Around("@annotation(LogDuration)")
	// public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws
	// Throwable {
	// return joinPoint.proceed();
	// }

	@Around("@annotation(com.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}

}
