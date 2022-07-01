package com.ceiba.dominio.excepcion;

public class DateException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public DateException(String message)
    {
        super(message);
    }
}