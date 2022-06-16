package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.RoomEntity;
import com.ceiba.adapter.repository.jdbc.RoomDAO;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.util.List;

@Repository
public class RoomDAOImplementation implements RoomDAO
{
    private Connection connection;

    @Override
    public List<RoomEntity> findAll()
    {
        return null;
    }

    @Override
    public RoomEntity findById()
    {
        return null;
    }

    @Override
    public void save(RoomEntity room)
    {

    }

    @Override
    public void update(RoomEntity room)
    {

    }

    @Override
    public void delete(Long id)
    {

    }
}
