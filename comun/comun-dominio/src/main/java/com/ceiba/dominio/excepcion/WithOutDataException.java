package com.ceiba.dominio.excepcion;

public class WithOutDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public WithOutDataException(String message) {
        super(message);
    }
}
