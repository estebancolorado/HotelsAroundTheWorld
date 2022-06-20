package com.ceiba.testdatabuilder;

import com.ceiba.dto.DestinationDTO;

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

    public DestinationDTO build()
    {
        return new DestinationDTO(city, country, hotel.build());
    }
}