package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepository;
import com.ceiba.utilitarian.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceGetReservations
{
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ServiceCalculatePrice serviceCalculatePrice;

    public List<ReservationSummaryDTO> implement()
    {
        var reservations = this.reservationRepository.getAll();

        if(reservations.isEmpty())
        {
            throw new IllegalArgumentException(Message.THERE_IS_NOT_RESERVATIONS);
        }

        reservations.forEach(reservation ->
        {
            reservation.setPesosPrice(this.serviceCalculatePrice.calculateCurrency(reservation.getDollarPrice()));
        });

        return reservations;
    }
}
