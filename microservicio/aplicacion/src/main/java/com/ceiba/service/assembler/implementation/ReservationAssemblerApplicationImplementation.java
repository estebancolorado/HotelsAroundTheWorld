package com.ceiba.service.assembler.implementation;

import com.ceiba.dto.ReservationDTO;
import com.ceiba.formatter.FormatDate;
import com.ceiba.model.Reservation;
import com.ceiba.service.assembler.ReservationAssemblerApplication;
import static com.ceiba.service.assembler.implementation.DestinationAssemblerApplicationImplementation.getDestinationAssembler;

public class ReservationAssemblerApplicationImplementation implements ReservationAssemblerApplication
{
    private static final ReservationAssemblerApplication INSTANCE = new ReservationAssemblerApplicationImplementation();

    private ReservationAssemblerApplicationImplementation()
    {

    }

    public static ReservationAssemblerApplication getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromDTO(ReservationDTO dto)
    {
        return Reservation.create(FormatDate.getDate(dto.getCheckIn()), FormatDate.getDate(dto.getCheckOut()), getDestinationAssembler().assembleDomainFromDTO(dto.getDestination()));
    }

    @Override
    public ReservationDTO assembleDTOFromDomain(Reservation domain)
    {
        return new ReservationDTO(FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), getDestinationAssembler().assembleDTOFromDomain(domain.getDestination()));
    }
}