package com.ceiba.reservation.adapter.assembler.implementation;

import com.ceiba.reservation.adapter.entity.HotelEntity;
import com.ceiba.reservation.adapter.assembler.HotelAssemblerInfrastructure;
import com.ceiba.reservation.model.entity.Hotel;

public final class HotelAssemblerInfrastructureImplementation implements HotelAssemblerInfrastructure
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