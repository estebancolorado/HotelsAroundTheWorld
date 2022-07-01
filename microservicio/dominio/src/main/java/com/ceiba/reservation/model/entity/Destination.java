package com.ceiba.reservation.model.entity;

import com.ceiba.dominio.excepcion.LengthException;
import com.ceiba.dominio.excepcion.WithOutDataException;
import com.ceiba.utilitarian.Constant;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateString;
import lombok.Getter;

@Getter
public final class Destination
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
            throw new WithOutDataException(Message.CITY_CANNOT_BE_EMPTY);
        }

        if(ValidateString.isLengthInvalid(city, Constant.MINIMUM_LENGTH_OF_CITY, Constant.MAXIMUM_LENGTH_OF_CITY))
        {
            throw new LengthException(Message.INVALID_CITY_LENGTH);
        }

        this.city = city;
    }

    private void setCountry(String country)
    {
        if(ValidateString.isStringEmpty(country))
        {
            throw new WithOutDataException(Message.COUNTRY_CANNOT_BE_EMPTY);
        }

        if(ValidateString.isLengthInvalid(country, Constant.MINIMUM_LENGTH_OF_COUNTRY, Constant.MAXIMUM_LENGTH_OF_COUNTRY))
        {
            throw new LengthException(Message.INVALID_COUNTRY_LENGTH);
        }

        this.country = country;
    }
}