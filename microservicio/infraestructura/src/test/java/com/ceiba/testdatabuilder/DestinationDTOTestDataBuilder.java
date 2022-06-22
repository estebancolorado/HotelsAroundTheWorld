package com.ceiba.testdatabuilder;

import com.ceiba.reservation.command.DestinationCommand;

public class DestinationDTOTestDataBuilder
{
    private final String city;
    private final String country;
    private final HotelDTOTestDataBuilder hotel;

    public DestinationDTOTestDataBuilder()
    {
        this.city = "Medellin";
        this.country = "Colombia";
        this.hotel = new HotelDTOTestDataBuilder();
    }

    public DestinationCommand build()
    {
        return new DestinationCommand(city, country, hotel.build());
    }
}