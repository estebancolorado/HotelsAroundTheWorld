package com.ceiba.validator;

public class ValidateString
{
    private static final String DATE_PATTERN = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";

    private ValidateString()
    {

    }

    public static boolean isStringNull(String string)
    {
        return ValidateObject.isNull(string);
    }

    public static String getDefaultValue(String string)
    {
        return ValidateObject.getDefaultValue(string, "");
    }

    public static String applyTrim(String string)
    {
        return getDefaultValue(string.trim());
    }

    public static boolean isStringEmpty(String string)
    {
        return isStringNull(string) || "".equals(applyTrim(string));
    }

    public static boolean isMinimumLengthValid(String string, int minimumLength)
    {
        return ValidateNumber.isNumberGreaterThanOrEqual(applyTrim(string).length(), minimumLength);
    }

    public static boolean isMaximumLengthValid(String string, int maximumLength)
    {
        return applyTrim(string).length() <= maximumLength;
    }

    public static boolean isLengthInvalid(String string, int minimumLength, int maximumLength)
    {
        return !isMinimumLengthValid(string, minimumLength) || !isMaximumLengthValid(string, maximumLength);
    }

    public static boolean isStringPatternAccepted(String string, String pattern)
    {
        return applyTrim(string).matches(pattern);
    }

    public static boolean isDateWrong(String string)
    {
        if(isStringNull(string))
        {
            return true;
        }

        return !isStringPatternAccepted(string, DATE_PATTERN);
    }
}