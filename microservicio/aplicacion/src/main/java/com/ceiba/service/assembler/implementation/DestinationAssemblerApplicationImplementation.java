package com.ceiba.service.assembler.implementation;


import com.ceiba.dto.DestinationDTO;
import com.ceiba.model.Destination;
import com.ceiba.service.assembler.DestinationAssemblerApplication;
import static com.ceiba.service.assembler.implementation.HotelAssemblerApplicationImplementation.getHotelAssembler;

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
        return Destination.create(dto.getCity(), dto.getCountry(), getHotelAssembler().assembleDomainFromDTO(dto.getHotel()));
    }

    @Override
    public DestinationDTO assembleDTOFromDomain(Destination domain)
    {
        return new DestinationDTO(domain.getCity(), domain.getCountry(), getHotelAssembler().assembleDTOFromDomain(domain.getHotel()));
    }
}