package com.ceiba.reservation.model.assembler;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.model.entity.Reservation;

public interface ReservationAssemblerDomain
{
    ReservationSummaryDTO assembleDTOFromDomain(Reservation reservation, double dollarPrice, double pesosPrice, Long id);
}