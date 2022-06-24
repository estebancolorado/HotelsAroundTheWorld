package com.ceiba.reservation.command.handler;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reservation.service.ServiceDeleteReservation;
import org.springframework.stereotype.Component;

@Component
public class DeleteReservationHandler implements ManejadorComando<Long>
{
    private final ServiceDeleteReservation serviceDeleteReservation;

    public DeleteReservationHandler(ServiceDeleteReservation serviceDeleteReservation)
    {
        this.serviceDeleteReservation = serviceDeleteReservation;
    }

    @Override
    public void ejecutar(Long comando)
    {
        this.serviceDeleteReservation.implement(comando);
    }
}