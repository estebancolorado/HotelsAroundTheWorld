package com.ceiba.reservation.command.handler;

import com.ceiba.reservation.service.ServiceDeleteReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReservationHandler
{
    @Autowired
    ServiceDeleteReservation serviceDeleteReservation;

    public Long implement(Long id)
    {
        return this.serviceDeleteReservation.implement(id);
    }
}