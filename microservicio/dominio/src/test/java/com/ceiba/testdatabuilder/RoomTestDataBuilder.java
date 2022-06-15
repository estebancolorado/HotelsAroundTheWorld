package com.ceiba.testdatabuilder;

import com.ceiba.model.Room;

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