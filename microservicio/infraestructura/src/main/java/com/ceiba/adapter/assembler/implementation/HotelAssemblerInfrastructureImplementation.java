package com.ceiba.adapter.assembler.implementation;

import com.ceiba.adapter.entity.HotelEntity;
import com.ceiba.adapter.assembler.HotelAssemblerInfrastructure;
import com.ceiba.model.Hotel;

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
        return Hotel.create(entity.getNumberStars(), RoomAssemblerInfrastructureImplementation.getRoomAssembler().assembleDomainsFromEntities(entity.getRooms()));
    }

    @Override
    public HotelEntity assembleEntityFromDomain(Hotel domain)
    {
        return new HotelEntity(1L, domain.getNumberStars(), RoomAssemblerInfrastructureImplementation.getRoomAssembler().assembleEntitiesFromDomains(domain.getRooms()));
    }
}