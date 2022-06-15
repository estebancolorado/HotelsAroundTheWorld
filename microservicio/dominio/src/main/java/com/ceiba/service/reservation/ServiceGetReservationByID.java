package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepository;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetReservationByID
{
    @Autowired
    ReservationRepository reservationRepository;

    public ReservationSummaryDTO implement(Long id)
    {
        var reservation = this.reservationRepository.getById(id);

        if(ValidateObject.isNull(reservation))
        {
                throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        return reservation;
    }
}