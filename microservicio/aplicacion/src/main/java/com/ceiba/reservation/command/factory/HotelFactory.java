package com.ceiba.reservation.command.factory;

import com.ceiba.reservation.command.HotelCommand;
import com.ceiba.reservation.model.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelFactory
{
    private final RoomFactory roomFactory;

    public HotelFactory(RoomFactory roomFactory)
    {
        this.roomFactory = roomFactory;
    }

    public Hotel build(HotelCommand hotel)
    {
        return Hotel.create(hotel.getNumberStars(), roomFactory.build(hotel.getRooms()));
    }
}