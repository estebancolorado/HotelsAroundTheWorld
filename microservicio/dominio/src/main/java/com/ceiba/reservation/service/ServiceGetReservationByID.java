package com.ceiba.reservation.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;

public class ServiceGetReservationByID
{
    private final ReservationQuery reservationQuery;

    public ServiceGetReservationByID(ReservationQuery reservationQuery)
    {
        this.reservationQuery = reservationQuery;
    }

    public ReservationSummaryDTO implement(Long id)
    {
        var reservation = this.reservationQuery.getById(id);

        if(ValidateObject.isNull(reservation))
        {
                throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        return reservation;
    }
}