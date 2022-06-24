package com.ceiba.reservation.service;

import com.ceiba.reservation.model.entity.Reservation;
import com.ceiba.reservation.port.repository.ReservationRepository;

public class ServiceSaveReservation
{
    private final ReservationRepository reservationRepository;

    public ServiceSaveReservation(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public Long implement(Reservation reservation)
    {
        var price = reservation.calculatePrice();

        return this.reservationRepository.save(reservation, price);
    }
}