package com.sample.core.exceptions;

/**
 * Exception will throw if any one get failed to login
 * @author cape
 *
 */
public class AuthenticationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4796166553381434636L;

	/**
	 * construct an  authentication exception
	 * @param message
	 * 			the failure message
	 */
	public AuthenticationException(String message) {
		super(message);
	}
	
	/**
	 * construct an authentication exception
	 * @param cause
	 * 			the original cause
	 */
	public AuthenticationException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * construct an authentication exception
	 * @param message
	 * 			the failure message
	 * @param t
	 * 			the original cause
	 */
	public AuthenticationException(String message,Throwable t) {
		super(message,t);
	}
}
