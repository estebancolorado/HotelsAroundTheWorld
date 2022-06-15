package com.ceiba.validator;

public final class ValidateObject
{
    private ValidateObject()
    {

    }

    public static <T> boolean isNull(T object)
    {
        return object == null;
    }

    public static <T> T getDefaultValue(T object, T defaultValue)
    {
        return isNull(object) ? defaultValue : object;
    }
}