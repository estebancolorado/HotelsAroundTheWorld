package com.ceiba.service;

import com.ceiba.port.ReservationRepositoryCommand;
import com.ceiba.port.ReservationRepositoryQuery;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteReservation
{
    private final ReservationRepositoryCommand reservationRepositoryCommand;
    private final ReservationRepositoryQuery reservationRepositoryQuery;

    public ServiceDeleteReservation(ReservationRepositoryCommand reservationRepositoryCommand, ReservationRepositoryQuery reservationRepositoryQuery)
    {
        this.reservationRepositoryCommand = reservationRepositoryCommand;
        this.reservationRepositoryQuery = reservationRepositoryQuery;
    }

    public Long implement(Long id)
    {
        if(ValidateObject.isNull(this.reservationRepositoryQuery.getById(id)))
        {
            throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        return this.reservationRepositoryCommand.delete(id);
    }
}