package com.ceiba.dominio.excepcion;

public class FormatException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public FormatException(String message)
    {
        super(message);
    }
}