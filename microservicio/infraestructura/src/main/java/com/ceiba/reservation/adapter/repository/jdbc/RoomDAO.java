package com.ceiba.reservation.adapter.repository.jdbc;

import com.ceiba.reservation.adapter.entity.RoomEntity;

import java.util.List;

public interface RoomDAO
{
    List<RoomEntity> findAll(Long hotelId);
    Long save(RoomEntity room, Long hotelId);
    Long delete(Long id);
}