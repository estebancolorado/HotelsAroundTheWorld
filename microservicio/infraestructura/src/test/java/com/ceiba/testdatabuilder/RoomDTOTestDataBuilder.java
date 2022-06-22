package com.ceiba.testdatabuilder;

import com.ceiba.reservation.command.RoomCommand;

public class RoomDTOTestDataBuilder
{
    private final int numberGuests;

    public RoomDTOTestDataBuilder()
    {
        this.numberGuests = 3;
    }

    public RoomCommand build()
    {
        return new RoomCommand(numberGuests);
    }
}