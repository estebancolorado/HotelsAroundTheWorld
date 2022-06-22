package com.ceiba.reservation.port.dao;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;

import java.util.List;

public interface ReservationQuery
{
    List<ReservationSummaryDTO> getAll();
    ReservationSummaryDTO getById(Long id);
}
