package com.ceiba.reservation.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.utilitarian.Message;
import java.util.List;

public class ServiceGetReservations
{
    private final ReservationQuery reservationQuery;

    public ServiceGetReservations(ReservationQuery reservationQuery)
    {
        this.reservationQuery = reservationQuery;
    }

    public List<ReservationSummaryDTO> implement()
    {
        var reservations = this.reservationQuery.getAll();

        if(reservations.isEmpty())
        {
            throw new IllegalArgumentException(Message.THERE_IS_NOT_RESERVATIONS);
        }

        return reservations;
    }
}
