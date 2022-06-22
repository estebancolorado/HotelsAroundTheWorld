package com.ceiba.reservation.command.handler;

import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.service.ServiceSaveReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.ceiba.reservation.command.assembler.implementation.ReservationAssemblerApplicationImplementation.getReservationAssembler;

@Component
public class SaveReservationHandler
{
    @Autowired
    ServiceSaveReservation serviceSaveReservation;

    public ReservationSummaryDTO implement(ReservationCommand reservation)
    {
        return this.serviceSaveReservation.implement(getReservationAssembler().assembleDomainFromCommand(reservation));
    }
}
