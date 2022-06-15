package com.ceiba.validator;

public class ValidateNumber
{
    private ValidateNumber()
    {

    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T getDefaultNumber(T number)
    {
        return (T) ValidateObject.getDefaultValue(number, 0);
    }

    public static <T extends Number> boolean isNumberGreater(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() > getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberLess(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() < getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberEqual(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() == getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberGreaterThanOrEqual(T number, T comparatorNumber)
    {
        return isNumberGreater(number, comparatorNumber) || isNumberEqual(number, comparatorNumber);
    }

    public static <T extends Number> boolean isNumberLessThanOrEqual(T number, T comparatorNumber)
    {
        return isNumberLess(number, comparatorNumber) || isNumberEqual(number, comparatorNumber);
    }

    public static <T extends Number> boolean isNumberBetween(T number, T lowerLimit, T upperLimit)
    {
        return isNumberGreaterThanOrEqual(number, lowerLimit) && isNumberLessThanOrEqual(number, upperLimit);
    }
}