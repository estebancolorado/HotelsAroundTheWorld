package com.ceiba.service;

import com.ceiba.port.ReservationRepository;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteReservation
{
    @Autowired
    ReservationRepository reservationRepository;

    public Long implement(Long id)
    {
        if(ValidateObject.isNull(this.reservationRepository.getById(id)))
        {
            throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        return this.reservationRepository.delete(id);
    }
}