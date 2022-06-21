package com.ceiba.port;

import com.ceiba.dto.ReservationSummaryDTO;

import java.util.List;

public interface ReservationRepositoryQuery
{
    List<ReservationSummaryDTO> getAll();
    ReservationSummaryDTO getById(Long id);
}
