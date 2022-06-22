package com.ceiba.testdatabuilder;

import com.ceiba.reservation.model.entity.Hotel;
import java.util.List;

public class HotelTestDataBuilder
{
    private final int numberStars;
    private final List<RoomTestDataBuilder> rooms;

    public HotelTestDataBuilder()
    {
        this.numberStars = 3;
        this.rooms = List.of(new RoomTestDataBuilder(), new RoomTestDataBuilder());
    }

    public Hotel build()
    {
        return Hotel.create(numberStars, List.of(rooms.get(0).build(), rooms.get(1).build()));
    }
}