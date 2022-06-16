package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.ReservationEntity;
import java.util.List;

public interface ReservationDAO
{
    List<ReservationEntity> findAll();
    ReservationEntity findById();
    void save(ReservationEntity reservation);
    void update(ReservationEntity reservation);
    void delete(Long id);
}