package com.ceiba.assembler.implementation;

import com.ceiba.assembler.HotelAssemblerApplication;
import com.ceiba.dto.HotelDTO;
import com.ceiba.model.Hotel;

public class HotelAssemblerApplicationImplementation implements HotelAssemblerApplication
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
    public Hotel assembleDomainFromDTO(HotelDTO dto)
    {
        return Hotel.create(dto.getNumberStars(), RoomAssemblerApplicationImplementation.getRoomAssembler().assembleDomainsFromDTOs(dto.getRooms()));
    }

    @Override
    public HotelDTO assembleDTOFromDomain(Hotel domain)
    {
        return new HotelDTO(domain.getNumberStars(), RoomAssemblerApplicationImplementation.getRoomAssembler().assembleDTOsFromDomains(domain.getRooms()));
    }
}