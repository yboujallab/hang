package com.ma.hang.core.aop;


import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

/**
 * @author yboujallab
 * Aop called after method call
 */
@Component
public class AopBeforeMethod implements MethodBeforeAdvice {

	private static Logger logger = (Logger) LoggerFactory.getLogger(AopBeforeMethod.class);
	
	public void before(Method method, Object[] args, Object target)
		throws Throwable {
		StringBuffer logMessage = new StringBuffer();
		logMessage.append("Class concerned: "
				+ method.getDeclaringClass().getName());
		logMessage.append(" - ");
		logMessage.append("Method called : "
				+ method.getName());
		logMessage.append(" with parameters [");
		// append args
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}
		logMessage.append("]");
		if (logger.isDebugEnabled())
		logger.debug(logMessage.toString());
	}
	
}
