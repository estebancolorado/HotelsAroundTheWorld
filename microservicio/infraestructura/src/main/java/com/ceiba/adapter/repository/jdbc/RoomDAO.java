package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.RoomEntity;
import java.util.List;

public interface RoomDAO
{
    List<RoomEntity> findAll(Long hotelId);
    Long save(RoomEntity room, Long hotelId);
    Long delete(Long id);
}