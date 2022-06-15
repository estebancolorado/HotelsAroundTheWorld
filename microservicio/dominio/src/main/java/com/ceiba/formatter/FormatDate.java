package com.ceiba.formatter;

import com.ceiba.validator.ValidateObject;
import com.ceiba.validator.ValidateString;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class FormatDate
{
    private static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

    private FormatDate()
    {

    }

    public static LocalDate getDate(String textDate)
    {
        if(ValidateString.isDateWrong(textDate))
        {
            return null;
        }

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_DD_MM_YYYY);

        return LocalDate.parse(textDate, pattern);
    }

    public static String getStringDate(LocalDate date)
    {
        if(ValidateObject.isNull(date))
        {
            return "";
        }

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_DD_MM_YYYY);

        return pattern.format(date);
    }
}