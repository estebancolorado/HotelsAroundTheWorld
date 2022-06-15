package com.ceiba.testdatabuilder;


import com.ceiba.model.Destination;

public class DestinationTestDataBuilder
{
    private final String city;
    private final String country;
    private final HotelTestDataBuilder hotel;

    public DestinationTestDataBuilder()
    {
        this.city = "Nueva York";
        this.country = "Estados Unidos de America";
        this.hotel = new HotelTestDataBuilder();
    }

    public Destination build()
    {
        return Destination.create(city, country, hotel.build());
    }
}