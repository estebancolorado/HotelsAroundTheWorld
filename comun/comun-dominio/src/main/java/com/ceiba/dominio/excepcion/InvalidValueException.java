package com.ceiba.dominio.excepcion;

public class InvalidValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public InvalidValueException(String message) {
        super(message);
    }
}
