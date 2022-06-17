package com.ceiba.service.assembler.implementation;

import com.ceiba.adapter.entity.ReservationEntity;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.formatter.FormatDate;
import com.ceiba.model.Reservation;
import com.ceiba.service.assembler.ReservationAssemblerInfrastructure;
import static com.ceiba.service.assembler.implementation.DestinationAssemblerInfrastructureImplementation.getDestinationAssembler;

public class ReservationAssemblerInfrastructureImplementation implements ReservationAssemblerInfrastructure
{
    private static final ReservationAssemblerInfrastructure INSTANCE = new ReservationAssemblerInfrastructureImplementation();

    private ReservationAssemblerInfrastructureImplementation()
    {

    }

    public static ReservationAssemblerInfrastructure getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromEntity(ReservationEntity entity)
    {
        return Reservation.create(FormatDate.getDate(entity.getCheckIn()), FormatDate.getDate(entity.getCheckOut()), getDestinationAssembler().assembleDomainFromEntity(entity.getDestination()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomain(Reservation domain)
    {
        return new ReservationEntity(1L, FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), 0.0, getDestinationAssembler().assembleEntityFromDomain(domain.getDestination()));
    }

    @Override
    public ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity)
    {
        return new ReservationSummaryDTO(entity.getId(), entity.getCheckIn(), entity.getCheckOut(), entity.getPrice(), 0.0, getDestinationAssembler().assembleDomainFromEntity(entity.getDestination()));
    }
}