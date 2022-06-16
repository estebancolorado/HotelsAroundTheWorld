package com.ceiba.service.assembler.implementation;

import com.ceiba.dto.HotelDTO;
import com.ceiba.model.Hotel;
import com.ceiba.service.assembler.HotelAssemblerApplication;
import static com.ceiba.service.assembler.implementation.RoomAssemblerApplicationImplementation.getRoomAssembler;

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
        return Hotel.create(dto.getNumberStars(), getRoomAssembler().assembleDomainsFromDTOs(dto.getRooms()));
    }

    @Override
    public HotelDTO assembleDTOFromDomain(Hotel domain)
    {
        return new HotelDTO(domain.getNumberStars(), getRoomAssembler().assembleDTOsFromDomains(domain.getRooms()));
    }
}