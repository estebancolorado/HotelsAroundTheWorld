package com.ceiba.reservation.model.entity;

import com.ceiba.formatter.FormatDate;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateString;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public final class Reservation
{
    private LocalDate checkIn;
    private LocalDate checkOut;
    private final Destination destination;

    private Reservation(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        this.destination = destination;
    }

    public static Reservation create(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        return new Reservation(checkIn, checkOut, destination);
    }

    private void setCheckIn(LocalDate checkIn)
    {
        if(ValidateString.isDateWrong(FormatDate.getStringDate(checkIn)))
        {
            throw new IllegalArgumentException(Message.INVALID_DATE_PATTERN);
        }

        if(checkIn.isBefore(LocalDate.now()))
        {
            throw new IllegalArgumentException(Message.CHECKIN_CANNOT_BE_LESS_THAN_TODAY);
        }

        this.checkIn = checkIn;
    }

    private void setCheckOut(LocalDate checkOut)
    {
        if(ValidateString.isDateWrong(FormatDate.getStringDate(checkOut)))
        {
            throw new IllegalArgumentException(Message.INVALID_DATE_PATTERN);
        }

        if(checkOut.isBefore(this.checkIn) || checkOut.isEqual(this.checkIn))
        {
            throw new IllegalArgumentException(Message.CHECKOUT_CANNOT_BE_LESS_THAN_OR_EQUAL_CHECKIN);
        }

        this.checkOut = checkOut;
    }
}