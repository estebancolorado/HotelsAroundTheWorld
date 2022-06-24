package com.ceiba.reservation.command.factory;

import com.ceiba.reservation.command.RoomCommand;
import com.ceiba.reservation.model.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomFactory
{
    public List<Room> build(List<RoomCommand> rooms)
    {
        return rooms.stream().map(new RoomFactory()::buildOne).toList();
    }

    private Room buildOne(RoomCommand room)
    {
        return Room.create(room.getNumberGuests());
    }
}
