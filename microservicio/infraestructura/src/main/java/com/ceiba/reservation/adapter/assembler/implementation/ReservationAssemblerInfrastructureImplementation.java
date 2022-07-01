package com.ceiba.reservation.adapter.assembler.implementation;

import com.ceiba.reservation.adapter.entity.ReservationEntity;
import com.ceiba.reservation.adapter.assembler.ReservationAssemblerInfrastructure;
import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.formatter.FormatDate;
import com.ceiba.reservation.model.entity.Reservation;

import static com.ceiba.reservation.adapter.assembler.implementation.DestinationAssemblerInfrastructureImplementation.getDestinationAssembler;

public final class ReservationAssemblerInfrastructureImplementation implements ReservationAssemblerInfrastructure
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
        return new ReservationEntity(1L, FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), domain.getPrice(), getDestinationAssembler().assembleEntityFromDomain(domain.getDestination()));
    }

    @Override
    public ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity)
    {
        return new ReservationSummaryDTO(entity.getId(), entity.getCheckIn(), entity.getCheckOut(), entity.getPrice(), getDestinationAssembler().assembleDomainFromEntity(entity.getDestination()));
    }
}