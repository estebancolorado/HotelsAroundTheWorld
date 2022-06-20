package com.ceiba.testdatabuilder;

import com.ceiba.dto.RoomDTO;

public class RoomDTOTestDataBuilder
{
    private final int numberGuests;

    public RoomDTOTestDataBuilder()
    {
        this.numberGuests = 3;
    }

    public RoomDTO build()
    {
        return new RoomDTO(numberGuests);
    }
}