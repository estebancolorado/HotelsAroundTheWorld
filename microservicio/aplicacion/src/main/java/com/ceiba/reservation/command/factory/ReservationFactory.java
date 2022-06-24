package com.ceiba.reservation.command.factory;

import com.ceiba.formatter.FormatDate;
import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.reservation.model.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationFactory
{
    private final DestinationFactory destinationFactory;

    public ReservationFactory(DestinationFactory destinationFactory)
    {
        this.destinationFactory = destinationFactory;
    }

    public Reservation build(ReservationCommand reservation)
    {
        return Reservation.create(FormatDate.getDate(reservation.getCheckIn()), FormatDate.getDate(reservation.getCheckOut()), destinationFactory.build(reservation.getDestination()));
    }
}
