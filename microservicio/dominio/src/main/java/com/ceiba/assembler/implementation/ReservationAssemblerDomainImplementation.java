package com.ceiba.assembler.implementation;

import com.ceiba.assembler.ReservationAssemblerDomain;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.formatter.FormatDate;
import com.ceiba.model.Reservation;

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