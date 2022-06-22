package com.ceiba.reservation.command.assembler.implementation;

import com.ceiba.reservation.command.RoomCommand;
import com.ceiba.reservation.command.assembler.RoomAssemblerApplication;
import com.ceiba.reservation.model.entity.Room;

import java.util.List;

public final class RoomAssemblerApplicationImplementation implements RoomAssemblerApplication
{
    private static final RoomAssemblerApplication INSTANCE = new RoomAssemblerApplicationImplementation();

    private RoomAssemblerApplicationImplementation()
    {

    }

    public static RoomAssemblerApplication getRoomAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Room assembleDomainFromCommand(RoomCommand dto)
    {
        return Room.create(dto.getNumberGuests());
    }

    @Override
    public RoomCommand assembleCommandFromDomain(Room domain)
    {
        return new RoomCommand(domain.getNumberGuests());
    }

    @Override
    public List<Room> assembleDomainsFromDTOs(List<RoomCommand> dtos)
    {
        return dtos.stream().map(getRoomAssembler()::assembleDomainFromCommand).toList();
    }

    @Override
    public List<RoomCommand> assembleDTOsFromDomains(List<Room> domains)
    {
        return domains.stream().map(getRoomAssembler()::assembleCommandFromDomain).toList();
    }
}