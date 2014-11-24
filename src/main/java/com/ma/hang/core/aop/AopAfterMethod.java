package com.ma.hang.core.aop;

import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

/**
 * @author yboujallab
 * Aop after called after method execution
 */
@Component
public class AopAfterMethod implements AfterReturningAdvice{
	private static ch.qos.logback.classic.Logger logger = (Logger) LoggerFactory.getLogger(AopAfterMethod.class);
	
	public void afterReturning(Object returnValue, Method method,
		Object[] args, Object target) throws Throwable {
		StringBuffer logMessage = new StringBuffer();
		logMessage.append("Class concerned: "
				+ method.getDeclaringClass().getName());
		logMessage.append(" - ");
		logMessage.append("Method called : "
				+ method.getName());
		logMessage.append("[ Return result : ");
		logMessage.append(returnValue);
		logMessage.append("]");
		if (logger.isDebugEnabled())
			logger.debug(logMessage.toString());
	}
}
