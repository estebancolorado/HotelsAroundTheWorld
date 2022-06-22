package com.ceiba.reservation.adapter.repository.jdbc;

import com.ceiba.reservation.adapter.entity.ReservationEntity;

import java.util.List;

public interface ReservationDAO
{
    List<ReservationEntity> findAll();
    ReservationEntity findById(Long id);
    Long save(ReservationEntity reservation, Long destinationId);
    Long delete(Long id);
}