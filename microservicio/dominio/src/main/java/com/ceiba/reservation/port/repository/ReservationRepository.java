package com.ceiba.reservation.port.repository;

import com.ceiba.reservation.model.entity.Reservation;

public interface ReservationRepository
{
    Long save(Reservation reservation, double price);
    Long delete(Long id);
}