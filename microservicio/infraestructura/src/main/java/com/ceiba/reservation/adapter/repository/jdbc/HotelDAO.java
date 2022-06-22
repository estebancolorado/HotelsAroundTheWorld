package com.ceiba.reservation.adapter.repository.jdbc;

import com.ceiba.reservation.adapter.entity.HotelEntity;

public interface HotelDAO
{
    HotelEntity findById(Long id);
    Long save(HotelEntity hotel);
    Long delete(Long id);
}