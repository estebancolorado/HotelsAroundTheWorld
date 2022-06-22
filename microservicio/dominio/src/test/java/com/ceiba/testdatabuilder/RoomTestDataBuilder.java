package com.ceiba.testdatabuilder;

import com.ceiba.reservation.model.entity.Room;

public class RoomTestDataBuilder
{
    private final int numberGuests;

    public RoomTestDataBuilder()
    {
        this.numberGuests = 2;
    }

    public Room build()
    {
        return Room.create(numberGuests);
    }
}