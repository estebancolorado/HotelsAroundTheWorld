package com.ceiba.reservation.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.utilitarian.Message;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceGetReservations
{
    private final ServiceCalculatePrice serviceCalculatePrice;

    private final ReservationQuery reservationQuery;

    public ServiceGetReservations(ServiceCalculatePrice serviceCalculatePrice, ReservationQuery reservationQuery)
    {
        this.serviceCalculatePrice = serviceCalculatePrice;
        this.reservationQuery = reservationQuery;
    }

    public List<ReservationSummaryDTO> implement()
    {
        var reservations = this.reservationQuery.getAll();

        if(reservations.isEmpty())
        {
            throw new IllegalArgumentException(Message.THERE_IS_NOT_RESERVATIONS);
        }

        reservations.forEach(reservation -> reservation.setPesosPrice(this.serviceCalculatePrice.calculateCurrency(reservation.getDollarPrice())));

        return reservations;
    }
}
