package com.ceiba.assembler;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;

public interface ReservationAssemblerDomain
{
    ReservationSummaryDTO assembleDTOFromDomain(Reservation reservation, double dollarPrice, double pesosPrice, Long id);
}