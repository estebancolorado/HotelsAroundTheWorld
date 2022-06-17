package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.HotelEntity;
import java.util.List;

public interface HotelDAO
{
    List<HotelEntity> findAll();
    HotelEntity findById(Long id);
    Long save(HotelEntity hotel);
    Long update(HotelEntity hotel);
    Long delete(Long id);
}