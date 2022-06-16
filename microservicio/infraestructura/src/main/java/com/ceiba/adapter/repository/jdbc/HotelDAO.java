package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.HotelEntity;
import java.util.List;

public interface HotelDAO
{
    List<HotelEntity> findAll();
    HotelEntity findById();
    void save(HotelEntity hotel);
    void update(HotelEntity hotel);
    void delete(Long id);
}