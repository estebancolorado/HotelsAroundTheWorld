package com.ceiba.reservation.adapter.assembler.implementation;

import com.ceiba.reservation.adapter.assembler.DestinationAssemblerInfrastructure;
import com.ceiba.reservation.adapter.entity.DestinationEntity;
import com.ceiba.reservation.model.entity.Destination;

public final class DestinationAssemblerInfrastructureImplementation implements DestinationAssemblerInfrastructure
{
    private static final DestinationAssemblerInfrastructure INSTANCE = new DestinationAssemblerInfrastructureImplementation();

    private DestinationAssemblerInfrastructureImplementation()
    {

    }

    public static DestinationAssemblerInfrastructure getDestinationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Destination assembleDomainFromEntity(DestinationEntity entity)
    {
        return Destination.create(entity.getCity(), entity.getCountry(), HotelAssemblerInfrastructureImplementation.getHotelAssembler().assembleDomainFromEntity(entity.getHotel()));
    }

    @Override
    public DestinationEntity assembleEntityFromDomain(Destination domain)
    {
        return new DestinationEntity(1L, domain.getCity(), domain.getCountry(), HotelAssemblerInfrastructureImplementation.getHotelAssembler().assembleEntityFromDomain(domain.getHotel()));
    }
}