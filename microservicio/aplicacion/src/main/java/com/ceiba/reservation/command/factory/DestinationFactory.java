package com.ceiba.reservation.command.factory;

import com.ceiba.reservation.command.DestinationCommand;
import com.ceiba.reservation.model.entity.Destination;
import org.springframework.stereotype.Component;

@Component
public class DestinationFactory
{
    private final HotelFactory hotelFactory;

    public DestinationFactory(HotelFactory hotelFactory)
    {
        this.hotelFactory = hotelFactory;
    }

    public Destination build(DestinationCommand destination)
    {
        return Destination.create(destination.getCity(), destination.getCountry(), hotelFactory.build(destination.getHotel()));
    }
}
