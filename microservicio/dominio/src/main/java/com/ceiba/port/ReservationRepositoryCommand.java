package com.ceiba.port;

import com.ceiba.model.Reservation;

public interface ReservationRepositoryCommand
{
    Long save(Reservation reservation, double price);
    Long delete(Long id);
}