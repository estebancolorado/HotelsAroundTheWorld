package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.RoomEntity;
import java.util.List;

public interface RoomDAO
{
    List<RoomEntity> findAll();
    RoomEntity findById();
    void save(RoomEntity room);
    void update(RoomEntity room);
    void delete(Long id);
}