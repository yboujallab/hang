package com.ma.hang.core.exception;

/**
 * @author yboujallab
 *
 */
public interface Error {

	
	/**
	 * Error code.
	 * 
	 * @return code de l'erreur.
	 */
	String getCode();

	/**
	 * Error message.
	 * 
	 * @return message par defaut
	 */
	String getMessage();
}

