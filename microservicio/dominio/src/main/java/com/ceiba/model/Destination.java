package com.ceiba.model;

import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateString;
import lombok.Getter;

@Getter
public class Destination
{
    private String city;
    private String country;
    private final Hotel hotel;

    private Destination(String city, String country, Hotel hotel)
    {
        setCity(city);
        setCountry(country);
        this.hotel = hotel;
    }

    public static Destination create(String city, String country, Hotel hotel)
    {
        return new Destination(city, country, hotel);
    }

    private void setCity(String city)
    {
        if(ValidateString.isStringEmpty(city))
        {
            throw new IllegalArgumentException(Message.CITY_CANNOT_BE_EMPTY);
        }

        if(ValidateString.isLengthInvalid(city, 1, 89))
        {
            throw new IllegalArgumentException(Message.INVALID_CITY_LENGTH);
        }

        this.city = city;
    }

    private void setCountry(String country)
    {
        if(ValidateString.isStringEmpty(country))
        {
            throw new IllegalArgumentException(Message.COUNTRY_CANNOT_BE_EMPTY);
        }

        if(ValidateString.isLengthInvalid(country, 1, 48))
        {
            throw new IllegalArgumentException(Message.INVALID_COUNTRY_LENGTH);
        }

        this.country = country;
    }
}