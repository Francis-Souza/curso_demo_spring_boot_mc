package com.joinsolutions.curso_demo_spring_boot_mc.services.exceptions;

public class DatabaseException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	
	public DatabaseException (String msg) {		
		super(msg);		
	}
}
