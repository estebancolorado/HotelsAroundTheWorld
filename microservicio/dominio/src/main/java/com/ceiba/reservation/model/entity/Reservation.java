package com.ceiba.reservation.model.entity;

import com.ceiba.dominio.excepcion.DateException;
import com.ceiba.dominio.excepcion.FormatException;
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
    private final double price;
    private final Destination destination;

    private Reservation(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        this.destination = destination;
        this.price = calculatePrice();
    }

    public static Reservation create(LocalDate checkIn, LocalDate checkOut, Destination destination)
    {
        return new Reservation(checkIn, checkOut, destination);
    }

    private void setCheckIn(LocalDate checkIn)
    {
        if(ValidateString.isDateWrong(FormatDate.getStringDate(checkIn)))
        {
            throw new FormatException(Message.INVALID_DATE_PATTERN);
        }

        if(checkIn.isBefore(LocalDate.now()))
        {
            throw new DateException(Message.CHECKIN_CANNOT_BE_LESS_THAN_TODAY);
        }

        this.checkIn = checkIn;
    }

    private void setCheckOut(LocalDate checkOut)
    {
        if(ValidateString.isDateWrong(FormatDate.getStringDate(checkOut)))
        {
            throw new FormatException(Message.INVALID_DATE_PATTERN);
        }

        if(checkOut.isBefore(this.checkIn) || checkOut.isEqual(this.checkIn))
        {
            throw new DateException(Message.CHECKOUT_CANNOT_BE_LESS_THAN_OR_EQUAL_CHECKIN);
        }

        this.checkOut = checkOut;
    }

    private double calculatePrice()
    {
        double finalPrice = Constant.INITIAL_PRICE;

        if(this.destination.getHotel().getNumberStars() > 1)
        {
            finalPrice = getPriceDependingNumberStars(finalPrice);
        }

        if(this.destination.getHotel().getRooms().size() > 1)
        {
            finalPrice = getPriceDependingNumberGuestsInRooms(finalPrice);
        }

        finalPrice = getPriceDependingNumberGuestsInASingleRoom(finalPrice);

        long days = ChronoUnit.DAYS.between(this.checkIn, this.checkOut);

        finalPrice = finalPrice * days;

        return Math.round(finalPrice*100.0)/100.0;
    }

    private double getPriceDependingNumberGuestsInASingleRoom(double finalPrice)
    {
        for(int i = 0; i < this.destination.getHotel().getRooms().size(); i++)
        {
            finalPrice = finalPrice * this.destination.getHotel().getRooms().get(0).getNumberGuests();
        }
        return finalPrice;
    }

    private double getPriceDependingNumberGuestsInRooms(double finalPrice)
    {
        for(int i = 0; i < this.destination.getHotel().getRooms().size() - 1; i++)
        {
            finalPrice = finalPrice + (finalPrice * Constant.PERCENTAGE_REGARDING_THE_NUMBER_OF_GUESTS);
        }
        return finalPrice;
    }

    private double getPriceDependingNumberStars(double finalPrice)
    {
        for(int i = 0; i < this.destination.getHotel().getNumberStars() - 1; i++)
        {
            finalPrice = finalPrice + (finalPrice * Constant.PERCENTAGE_REGARDING_THE_NUMBER_OF_STARS);
        }
        return finalPrice;
    }
}
