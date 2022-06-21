package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.HotelEntity;

public interface HotelDAO
{
    HotelEntity findById(Long id);
    Long save(HotelEntity hotel);
    Long delete(Long id);
}