package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.revature.models.Car;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	/* Advice annotation */
	/*
	 * @Before
	 * @After
	 * @AfterReturning
	 * @AfterThrowing
	 * @Around
	 * 
	 */
	
	//        *           com.revature.*  ..* (..)
	// Any return type, in any any method, with any parameters
	@Before(value="execution(* com.revature.*..*(..))")
	public void loggingMethod(JoinPoint jp) {
		logger.warn("Method being called: " + jp.getSignature());
	}
	
	@Around(value="execution(com.revature.models.Car com.revature.services..*(int))")
	public Car carMutator(ProceedingJoinPoint pjp) throws Throwable {
		Integer i = (int) pjp.getArgs()[0];
		System.out.println(i);
		i = 1;
		logger.warn("Before!");
		Car car = (Car) pjp.proceed(new Object[]{i});
		car.setColor("Black");
		logger.warn("After!");
		return car;
	}
}
