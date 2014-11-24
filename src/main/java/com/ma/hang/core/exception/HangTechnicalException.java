package com.ma.hang.core.exception;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author yboujallab
 * Hang technical exception class
 */
public class HangTechnicalException extends Exception{

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -7173252565188133318L;

	private final String[] parametres;

	private String strstackTrace = new String();
	
	private final String code;


	/**
	 * Constructor with Error interface
	 * @param error
	 */
	public HangTechnicalException(Error error) {
		super(error.getMessage());
		this.code = error.getCode();
		this.parametres = null;

	}
	
	/**
	 * @param error
	 * @param message
	 */
	public HangTechnicalException(Error error,String message) {
		super(message);
		this.code = error.getCode();
		this.parametres = null;

	}
	
	/**
	 * @param error
	 * @param message
	 * @param parametres
	 */
	public HangTechnicalException(Error error,String message, String[] parametres) {
		super(message);
		this.code = error.getCode();
		this.parametres = parametres;

	}	
	/**
	 * @param error
	 * @param message
	 * @param pCause
	 * @param parametres
	 */
	public HangTechnicalException(Error error,String message, Throwable pCause, String[] parametres) {
		super(message, pCause);
		this.code = error.getCode();
		this.parametres = parametres;

	}	
	
	/**
	 * @param error
	 * @param parametres
	 */
	public HangTechnicalException(Error error, String[] parametres) {
		super(error.getMessage());
		this.code = error.getCode();
		this.parametres = null;

	}

	/**
	 * @param pCause
	 */
	public HangTechnicalException(Throwable pCause) {
		super(pCause);
		OutputStream os = new java.io.ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		pCause.printStackTrace(ps);
		strstackTrace = os.toString();
		this.parametres = null;
		this.code = "00";
	}
	
	/**
	 * @param error
	 * @param pCause
	 */
	public HangTechnicalException(Error error, Throwable pCause) {
		super(error.getMessage(), pCause);
		// stack trace
		OutputStream os = new java.io.ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		pCause.printStackTrace(ps);
		strstackTrace = os.toString();
		this.parametres = null;
		this.code = error.getCode();
	}
	
	/**
	 * @param error
	 * @param pCause
	 * @param parametres
	 */
	public HangTechnicalException(Error error, Throwable pCause,String[] parametres) {
		super(error.getMessage(), pCause);
		// stack trace
		OutputStream os = new java.io.ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		pCause.printStackTrace(ps);
		strstackTrace = os.toString();
		this.parametres = parametres;
		this.code = error.getCode();
	}
	
	/**
	 * @param message
	 * @param pCause
	 */
	public HangTechnicalException(String message, Throwable pCause) {
		super(message, pCause);
		OutputStream os = new java.io.ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		pCause.printStackTrace(ps);
		strstackTrace = os.toString();
		this.parametres = null;
		this.code = "00";
	}
	
	/**
	 * @param message
	 */
	public HangTechnicalException(String message) {
		super(message);
		strstackTrace = message;
		this.parametres = null;
		this.code = "00";
	}
	
	/**
	 * @return stack trace
	 */
	public String getStrstackTrace() {
		return strstackTrace;
	}

	/**
	 * @param strstackTrace
	 */
	public void setStrstackTrace(String strstackTrace) {
		this.strstackTrace = strstackTrace;
	}

	/**
	 * @return parameters
	 */
	public String[] getParametres() {
		return parametres;
	}

	@Override
	public String toString() {
		return "ExceptionTechnique [code=" + this.code.toString() + ",message=" + this.getMessage() + ", cause="
				+ getCause() + "]";
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
}
