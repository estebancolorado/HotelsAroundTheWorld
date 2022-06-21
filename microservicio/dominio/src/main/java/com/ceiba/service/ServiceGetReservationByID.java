package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepositoryCommand;
import com.ceiba.port.ReservationRepositoryQuery;
import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetReservationByID
{
    private final ServiceCalculatePrice serviceCalculatePrice;
    private final ReservationRepositoryQuery reservationRepositoryQuery;

    public ServiceGetReservationByID(ServiceCalculatePrice serviceCalculatePrice, ReservationRepositoryQuery reservationRepositoryQuery)
    {
        this.serviceCalculatePrice = serviceCalculatePrice;
        this.reservationRepositoryQuery = reservationRepositoryQuery;
    }

    public ReservationSummaryDTO implement(Long id)
    {
        var reservation = this.reservationRepositoryQuery.getById(id);

        if(ValidateObject.isNull(reservation))
        {
                throw new IllegalArgumentException(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + id);
        }

        reservation.setPesosPrice(this.serviceCalculatePrice.calculateCurrency(reservation.getDollarPrice()));

        return reservation;
    }
}