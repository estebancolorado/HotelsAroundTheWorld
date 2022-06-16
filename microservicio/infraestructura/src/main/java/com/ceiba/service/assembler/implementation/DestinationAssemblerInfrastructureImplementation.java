package com.ceiba.service.assembler.implementation;

import com.ceiba.adapter.entity.DestinationEntity;
import com.ceiba.model.Destination;
import com.ceiba.service.assembler.DestinationAssemblerInfrastructure;
import static com.ceiba.service.assembler.implementation.HotelAssemblerInfrastructureImplementation.getHotelAssembler;

public class DestinationAssemblerInfrastructureImplementation implements DestinationAssemblerInfrastructure
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
        return Destination.create(entity.getCity(), entity.getCountry(), getHotelAssembler().assembleDomainFromEntity(entity.getHotel()));
    }

    @Override
    public DestinationEntity assembleEntityFromDomain(Destination domain)
    {
        return new DestinationEntity(1L, domain.getCity(), domain.getCountry(), getHotelAssembler().assembleEntityFromDomain(domain.getHotel()));
    }
}