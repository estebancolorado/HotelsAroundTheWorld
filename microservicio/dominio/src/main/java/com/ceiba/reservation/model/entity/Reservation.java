package com.ceiba.reservation.model.entity;

import com.ceiba.formatter.FormatDate;
import com.ceiba.utilitarian.Constant;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateString;
import lombok.Getter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public double calculatePrice()
    {
        double finalPrice = Constant.INITIAL_PRICE;

        if(this.destination.getHotel().getNumberStars() > 1)
        {
            for(int i = 0; i < this.destination.getHotel().getNumberStars() - 1; i++)
            {
                finalPrice = finalPrice + (finalPrice * Constant.PERCENTAGE_REGARDING_THE_NUMBER_OF_STARS);
            }
        }

        if(this.destination.getHotel().getRooms().size() > 1)
        {
            for(int i = 0; i < this.destination.getHotel().getRooms().size() - 1; i++)
            {
                finalPrice = finalPrice + (finalPrice * Constant.PERCENTAGE_REGARDING_THE_NUMBER_OF_GUESTS);
            }
        }

        for(int i = 0; i < this.destination.getHotel().getRooms().size(); i++)
        {
            finalPrice = finalPrice * this.destination.getHotel().getRooms().get(0).getNumberGuests();
        }

        long days = ChronoUnit.DAYS.between(this.checkIn, this.checkOut);

        finalPrice = finalPrice * days;

        return Math.round(finalPrice*100.0)/100.0;
    }
}