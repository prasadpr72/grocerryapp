package com.grocerryshop.mygrocerry;

public class GroccerryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GroccerryException(String errorMessage){
		super(errorMessage);
	}

}
