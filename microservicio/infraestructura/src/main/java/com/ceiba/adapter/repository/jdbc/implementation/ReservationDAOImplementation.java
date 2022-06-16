package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.ReservationEntity;
import com.ceiba.adapter.repository.jdbc.ReservationDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationDAOImplementation implements ReservationDAO
{
    @Override
    public List<ReservationEntity> findAll()
    {
        return null;
    }

    @Override
    public ReservationEntity findById()
    {
        return null;
    }

    @Override
    public void save(ReservationEntity reservation)
    {

    }

    @Override
    public void update(ReservationEntity reservation)
    {

    }

    @Override
    public void delete(Long id)
    {

    }
}