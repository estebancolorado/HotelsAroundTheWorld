package com.ceiba.adapter.repository.jdbc.mapper;

import com.ceiba.adapter.entity.HotelEntity;
import com.ceiba.adapter.repository.jdbc.RoomDAO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class HotelMapper implements RowMapper<HotelEntity>, MapperResult
{
    @Autowired
    RoomDAO roomDAO;

    @Override
    public HotelEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        var id = rs.getInt("id");
        var numberStars = rs.getInt("number_stars");
        var rooms = roomDAO.findAll((long) id);

        return new HotelEntity((long) id, numberStars, rooms);
    }
}