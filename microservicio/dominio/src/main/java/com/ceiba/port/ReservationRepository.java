package com.ceiba.port;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;

import java.util.List;

public interface ReservationRepository
{
    List<ReservationSummaryDTO> getAll();
    ReservationSummaryDTO getById(Long id);
    Long save(Reservation reservation, double price);
    Long delete(Long id);
}