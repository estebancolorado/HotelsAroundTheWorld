package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationDTO;
import com.ceiba.dto.ReservationSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.ceiba.assembler.implementation.ReservationAssemblerApplicationImplementation.getReservationAssembler;

@Component
public class ServiceApplicationSaveReservation
{
    @Autowired
    ServiceSaveReservation serviceSaveReservation;

    public ReservationSummaryDTO implement(ReservationDTO reservation)
    {
        return this.serviceSaveReservation.implement(getReservationAssembler().assembleDomainFromDTO(reservation));
    }
}
