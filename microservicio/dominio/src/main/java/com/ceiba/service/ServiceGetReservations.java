package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepositoryQuery;
import com.ceiba.utilitarian.Message;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceGetReservations
{
    private final ServiceCalculatePrice serviceCalculatePrice;

    private final ReservationRepositoryQuery reservationRepositoryQuery;

    public ServiceGetReservations(ServiceCalculatePrice serviceCalculatePrice, ReservationRepositoryQuery reservationRepositoryQuery)
    {
        this.serviceCalculatePrice = serviceCalculatePrice;
        this.reservationRepositoryQuery = reservationRepositoryQuery;
    }

    public List<ReservationSummaryDTO> implement()
    {
        var reservations = this.reservationRepositoryQuery.getAll();

        if(reservations.isEmpty())
        {
            throw new IllegalArgumentException(Message.THERE_IS_NOT_RESERVATIONS);
        }

        reservations.forEach(reservation -> reservation.setPesosPrice(this.serviceCalculatePrice.calculateCurrency(reservation.getDollarPrice())));

        return reservations;
    }
}
