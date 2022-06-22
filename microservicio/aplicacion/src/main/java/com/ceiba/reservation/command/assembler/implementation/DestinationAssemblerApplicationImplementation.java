package com.ceiba.reservation.command.assembler.implementation;


import com.ceiba.reservation.command.assembler.DestinationAssemblerApplication;
import com.ceiba.reservation.command.DestinationCommand;
import com.ceiba.reservation.model.entity.Destination;

public final class DestinationAssemblerApplicationImplementation implements DestinationAssemblerApplication
{
    private static final DestinationAssemblerApplication INSTANCE = new DestinationAssemblerApplicationImplementation();

    private DestinationAssemblerApplicationImplementation()
    {

    }

    public static DestinationAssemblerApplication getDestinationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Destination assembleDomainFromCommand(DestinationCommand dto)
    {
        return Destination.create(dto.getCity(), dto.getCountry(), HotelAssemblerApplicationImplementation.getHotelAssembler().assembleDomainFromCommand(dto.getHotel()));
    }

    @Override
    public DestinationCommand assembleCommandFromDomain(Destination domain)
    {
        return new DestinationCommand(domain.getCity(), domain.getCountry(), HotelAssemblerApplicationImplementation.getHotelAssembler().assembleCommandFromDomain(domain.getHotel()));
    }
}