package com.ceiba.dominio.excepcion;

public class LengthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LengthException(String message) {
        super(message);
    }
}
