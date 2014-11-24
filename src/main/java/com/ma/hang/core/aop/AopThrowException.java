package com.ma.hang.core.aop;


import java.io.OutputStream;
import java.io.PrintStream;

import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

/**
 * @author yboujallab
 * Aop manage exception
 */
@Component
public class AopThrowException implements ThrowsAdvice {

	private static Logger logger = (Logger) LoggerFactory.getLogger(AopThrowException.class);

	
	/**
	 * @param e
	 * @throws Throwable
	 */
	public void afterThrowing(Exception e) throws Throwable {
		StringBuffer logMessage = new StringBuffer();
		logMessage.append(getExceptionMsg(e));
		if(logger.isErrorEnabled())
			logger.error(logMessage.toString(),e);
	}
	
	/**
	 * @param pCause
	 * @return Exception msg
	 */
	public String getExceptionMsg(Exception pCause){
		// stack trace
		OutputStream os = new java.io.ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		pCause.printStackTrace(ps);
		return os.toString();
	}
}
