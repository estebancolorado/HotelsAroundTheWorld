package com.ceiba.testdatabuilder;

import com.ceiba.reservation.command.ReservationCommand;

public class ReservationDTOTestDataBuilder
{
    private final String checkIn;
    private final String checkOut;
    private final DestinationDTOTestDataBuilder destination;

    public ReservationDTOTestDataBuilder()
    {
        this.checkIn = "10/07/2022";
        this.checkOut = "15/07/2022";
        this.destination = new DestinationDTOTestDataBuilder();
    }

    public ReservationCommand build()
    {
        return new ReservationCommand(checkIn, checkOut, destination.build());
    }
}