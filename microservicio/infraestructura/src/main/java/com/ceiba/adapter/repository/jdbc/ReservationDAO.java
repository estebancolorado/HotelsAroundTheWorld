package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.ReservationEntity;
import java.util.List;

public interface ReservationDAO
{
    List<ReservationEntity> findAll();
    ReservationEntity findById(Long id);
    Long save(ReservationEntity reservation, Long destinationId);
    Long delete(Long id);
}