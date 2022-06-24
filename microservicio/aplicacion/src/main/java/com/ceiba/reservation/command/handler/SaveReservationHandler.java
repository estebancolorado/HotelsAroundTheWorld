package com.ceiba.reservation.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.reservation.command.factory.ReservationFactory;
import com.ceiba.reservation.service.ServiceSaveReservation;
import org.springframework.stereotype.Component;

@Component
public class SaveReservationHandler implements ManejadorComandoRespuesta<ReservationCommand, ComandoRespuesta<Long>>
{
    private final ReservationFactory reservationFactory;
    private final ServiceSaveReservation serviceSaveReservation;

    public SaveReservationHandler(ReservationFactory reservationFactory, ServiceSaveReservation serviceSaveReservation)
    {
        this.reservationFactory = reservationFactory;
        this.serviceSaveReservation = serviceSaveReservation;
    }
    @Override
    public ComandoRespuesta<Long> ejecutar(ReservationCommand comando)
    {
        return new ComandoRespuesta<>(serviceSaveReservation.implement(reservationFactory.build(comando)));
    }
}
