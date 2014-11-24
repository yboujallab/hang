package com.ma.hang.core.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import ch.qos.logback.classic.Logger;

/**
 * @author yboujallab
 * Arround aop called around method execution
 */
@Component
public class AopAroundMethod implements MethodInterceptor {

	private static Logger logger = (Logger) LoggerFactory.getLogger(AopAroundMethod.class);

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		StringBuffer logMessage = new StringBuffer();
		logMessage.append("Class concerned: "
				+ methodInvocation.getMethod().getDeclaringClass().getName());
		logMessage.append(" - ");
		logMessage.append("Method called : "
				+ methodInvocation.getMethod().getName());

		try {
			// proceed to original method call
			Object result = methodInvocation.proceed();
			stopWatch.stop();
			logMessage.append(" execution time: ");
			logMessage.append(stopWatch.getTotalTimeMillis());
			logMessage.append(" ms");
			if (logger.isDebugEnabled())
				logger.debug(logMessage.toString());
			return result;
		} catch (Exception e) {
			// same with ThrowsAdvice
			logMessage.append(")");
			logMessage.append(" Exception while executing Method : " +methodInvocation.getMethod().getName()+" : " +e.getMessage());
			if(logger.isErrorEnabled())
				logger.error(logMessage.toString(),e);
			throw e;
		}
	}

}
