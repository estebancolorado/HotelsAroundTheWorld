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
        if(ValidateObject.isNull(this.reservationQuery.getById(id)))
        {
            throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        return this.reservationRepository.delete(id);
    }
}