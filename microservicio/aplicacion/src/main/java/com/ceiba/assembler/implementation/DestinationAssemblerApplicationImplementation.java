package com.ceiba.assembler.implementation;


import com.ceiba.assembler.DestinationAssemblerApplication;
import com.ceiba.dto.DestinationDTO;
import com.ceiba.model.Destination;

public class DestinationAssemblerApplicationImplementation implements DestinationAssemblerApplication
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
    public Destination assembleDomainFromDTO(DestinationDTO dto)
    {
        return Destination.create(dto.getCity(), dto.getCountry(), HotelAssemblerApplicationImplementation.getHotelAssembler().assembleDomainFromDTO(dto.getHotel()));
    }

    @Override
    public DestinationDTO assembleDTOFromDomain(Destination domain)
    {
        return new DestinationDTO(domain.getCity(), domain.getCountry(), HotelAssemblerApplicationImplementation.getHotelAssembler().assembleDTOFromDomain(domain.getHotel()));
    }
}