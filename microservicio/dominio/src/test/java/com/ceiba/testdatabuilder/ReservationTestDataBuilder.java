package com.ceiba.testdatabuilder;


import com.ceiba.formatter.FormatDate;
import com.ceiba.model.Reservation;

import java.time.LocalDate;

public class ReservationTestDataBuilder
{
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final DestinationTestDataBuilder destination;

    public ReservationTestDataBuilder()
    {
        this.checkIn = FormatDate.getDate("10/07/2022");
        this.checkOut = FormatDate.getDate("20/07/2022");
        this.destination = new DestinationTestDataBuilder();
    }

    public Reservation build()
    {
        return Reservation.create(checkIn, checkOut, destination.build());
    }
}