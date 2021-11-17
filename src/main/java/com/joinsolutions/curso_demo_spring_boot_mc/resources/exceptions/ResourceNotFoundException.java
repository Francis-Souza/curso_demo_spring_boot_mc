package com.joinsolutions.curso_demo_spring_boot_mc.resources.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id );
	}
}
