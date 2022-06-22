package com.ceiba.reservation.model.assembler.implementation;

import com.ceiba.reservation.model.assembler.ReservationAssemblerDomain;
import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.formatter.FormatDate;
import com.ceiba.reservation.model.entity.Reservation;

public final class ReservationAssemblerDomainImplementation implements ReservationAssemblerDomain
{
    private static final ReservationAssemblerDomain INSTANCE = new ReservationAssemblerDomainImplementation();

    private ReservationAssemblerDomainImplementation()
    {

    }

    public static ReservationAssemblerDomain getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public ReservationSummaryDTO assembleDTOFromDomain(Reservation reservation, double dollarPrice, double pesosPrice, Long id)
    {
        return new ReservationSummaryDTO(id, FormatDate.getStringDate(reservation.getCheckIn()), FormatDate.getStringDate(reservation.getCheckOut()), dollarPrice, pesosPrice, reservation.getDestination());
    }
}