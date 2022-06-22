package com.ceiba.reservation.adapter.repository.jdbc;

import com.ceiba.reservation.adapter.entity.DestinationEntity;

public interface DestinationDAO
{
    DestinationEntity findById(Long id);
    Long save(DestinationEntity destination, Long hotelId);
    Long delete(Long id);
}