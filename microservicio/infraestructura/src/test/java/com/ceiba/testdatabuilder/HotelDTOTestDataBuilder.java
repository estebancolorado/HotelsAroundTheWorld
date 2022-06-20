package com.ceiba.testdatabuilder;

import com.ceiba.dto.HotelDTO;
import com.ceiba.dto.RoomDTO;
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

    public HotelDTO build()
    {
        List<RoomDTO> roomsDT0 = new ArrayList<>();

        roomsDT0.add(rooms.get(0).build());

        return new HotelDTO(numberStars, roomsDT0);
    }
}