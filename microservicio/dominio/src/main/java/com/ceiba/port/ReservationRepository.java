package com.ceiba.port;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;

public interface ReservationRepository
{
    ReservationSummaryDTO getById(Long id);
    Long save(Reservation reservation, double price);
    Long update(Reservation reservation, double price, Long id);
    void delete(Long id);
}