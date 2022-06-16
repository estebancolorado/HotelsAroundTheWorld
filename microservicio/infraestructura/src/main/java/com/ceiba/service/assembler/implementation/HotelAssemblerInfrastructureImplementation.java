package com.ceiba.service.assembler.implementation;

import com.ceiba.adapter.entity.HotelEntity;
import com.ceiba.model.Hotel;
import com.ceiba.service.assembler.HotelAssemblerInfrastructure;
import static com.ceiba.service.assembler.implementation.RoomAssemblerInfrastructureImplementation.getRoomAssembler;

public class HotelAssemblerInfrastructureImplementation implements HotelAssemblerInfrastructure
{
    private static final HotelAssemblerInfrastructure INSTANCE = new HotelAssemblerInfrastructureImplementation();

    private HotelAssemblerInfrastructureImplementation()
    {

    }

    public static HotelAssemblerInfrastructure getHotelAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Hotel assembleDomainFromEntity(HotelEntity entity)
    {
        return Hotel.create(entity.getNumberStars(), getRoomAssembler().assembleDomainsFromEntities(entity.getRooms()));
    }

    @Override
    public HotelEntity assembleEntityFromDomain(Hotel domain)
    {
        return new HotelEntity(1L, domain.getNumberStars(), getRoomAssembler().assembleEntitiesFromDomains(domain.getRooms()));
    }
}