package com.ceiba.reservation.command.assembler.implementation;

import com.ceiba.reservation.command.assembler.HotelAssemblerApplication;
import com.ceiba.reservation.command.HotelCommand;
import com.ceiba.reservation.model.entity.Hotel;

public final class HotelAssemblerApplicationImplementation implements HotelAssemblerApplication
{
    private static final HotelAssemblerApplication INSTANCE = new HotelAssemblerApplicationImplementation();

    private HotelAssemblerApplicationImplementation()
    {

    }

    public static HotelAssemblerApplication getHotelAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Hotel assembleDomainFromCommand(HotelCommand dto)
    {
        return Hotel.create(dto.getNumberStars(), RoomAssemblerApplicationImplementation.getRoomAssembler().assembleDomainsFromDTOs(dto.getRooms()));
    }

    @Override
    public HotelCommand assembleCommandFromDomain(Hotel domain)
    {
        return new HotelCommand(domain.getNumberStars(), RoomAssemblerApplicationImplementation.getRoomAssembler().assembleDTOsFromDomains(domain.getRooms()));
    }
}