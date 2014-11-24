package com.ma.hang.core.exception;

/**
 * @author yboujallab
 *
 */
public class HangFunctionalException extends Exception{
	private static final long serialVersionUID = 1L;

	  /**
	 * 
	 */
	public HangFunctionalException()
	  {
	  }

	  /**
	 * @param pMessage
	 * @param pCause
	 */
	public HangFunctionalException(String pMessage, Throwable pCause)
	  {
	    super(pMessage, pCause);
	  }

	  /**
	 * @param pMessage
	 */
	public HangFunctionalException(String pMessage)
	  {
	    super(pMessage);
	  }

	  /**
	 * @param pCause
	 */
	public HangFunctionalException(Throwable pCause)
	  {
	    super(pCause);
	  }
}
