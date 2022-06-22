package com.ceiba.testdatabuilder;

import com.ceiba.reservation.command.HotelCommand;
import com.ceiba.reservation.command.RoomCommand;
import java.util.ArrayList;
import java.util.List;

public class HotelDTOTestDataBuilder
{
    private final int numberStars;
    private final List<RoomDTOTestDataBuilder> rooms;

    public HotelDTOTestDataBuilder()
    {
        this.numberStars = 3;
        var room = new RoomDTOTestDataBuilder();
        this.rooms = List.of(room);
    }

    public HotelCommand build()
    {
        List<RoomCommand> roomsDT0 = new ArrayList<>();

        roomsDT0.add(rooms.get(0).build());

        return new HotelCommand(numberStars, roomsDT0);
    }
}