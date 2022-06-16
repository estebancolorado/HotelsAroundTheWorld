package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.HotelEntity;
import com.ceiba.adapter.repository.jdbc.HotelDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HotelDAOImplementation implements HotelDAO
{
    @Override
    public List<HotelEntity> findAll()
    {
        return null;
    }

    @Override
    public HotelEntity findById()
    {
        return null;
    }

    @Override
    public void save(HotelEntity hotel)
    {

    }

    @Override
    public void update(HotelEntity hotel)
    {

    }

    @Override
    public void delete(Long id)
    {

    }
}