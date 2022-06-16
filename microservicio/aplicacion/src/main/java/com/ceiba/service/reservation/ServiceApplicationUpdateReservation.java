package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationDTO;
import com.ceiba.dto.ReservationSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.ceiba.service.assembler.implementation.ReservationAssemblerApplicationImplementation.getReservationAssembler;

@Component
public class ServiceApplicationUpdateReservation
{
    @Autowired
    ServiceUpdateReservation serviceUpdateReservation;

    public ReservationSummaryDTO implement(Long id, ReservationDTO reservation)
    {
        return this.serviceUpdateReservation.implement(id, getReservationAssembler().assembleDomainFromDTO(reservation));
    }
}