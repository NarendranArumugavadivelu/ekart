package com.cooper.farming.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.cooper.farming.controller.*.*(..))")
	private void pointcutForControllers() {
		/***/
	}
	
	@Pointcut("execution(public * com.cooper.farming.service.impl.*.*(..))")
	private void pointcutForServices() {
		/***/
	}
	
	@Pointcut("pointcutForControllers() || pointcutForServices()")
	private void pointcutForControllersOrServiceCalls() {
		/***/
	}
	
	@Around("pointcutForControllersOrServiceCalls()")
	public Object aroundAdice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
		String[] parameterNames = codeSignature.getParameterNames();
		logger.debug("The method signature is {} " , codeSignature);
		Object[] args = proceedingJoinPoint.getArgs();
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				logger.debug("{} => Value of request parameter {} is: {}", proceedingJoinPoint.getSignature().getName(), parameterNames[i], args[i]);
			}
		}
		Object response = proceedingJoinPoint.proceed(args);
		logger.debug("{} => Response value is: {}" , proceedingJoinPoint.getSignature().getName(), response);
		return response;
	}
}
