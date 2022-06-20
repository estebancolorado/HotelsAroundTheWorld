package com.ceiba.testdatabuilder;

import com.ceiba.dto.ReservationDTO;

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

    public ReservationDTO build()
    {
        return new ReservationDTO(checkIn, checkOut, destination.build());
    }
}