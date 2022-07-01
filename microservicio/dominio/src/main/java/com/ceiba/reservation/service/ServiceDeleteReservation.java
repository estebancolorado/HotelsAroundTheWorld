package com.ceiba.reservation.service;

import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.reservation.port.repository.ReservationRepository;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;

public class ServiceDeleteReservation
{
    private final ReservationRepository reservationRepository;
    private final ReservationQuery reservationQuery;

    public ServiceDeleteReservation(ReservationRepository reservationRepository, ReservationQuery reservationQuery)
    {
        this.reservationRepository = reservationRepository;
        this.reservationQuery = reservationQuery;
    }

    public Long implement(Long id)
    {
        var reservation = this.reservationQuery.getById(id);

        if(ValidateObject.isNull(reservation))
        {
            throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        this.reservationRepository.delete(id);

        return id;
    }
}