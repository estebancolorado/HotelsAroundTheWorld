package com.ceiba.adapter.repository.jdbc.mapper;

import com.ceiba.adapter.entity.DestinationEntity;
import com.ceiba.adapter.repository.jdbc.HotelDAO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DestinationMapper implements RowMapper<DestinationEntity>, MapperResult
{
    @Autowired
    HotelDAO hotelDAO;

    @Override
    public DestinationEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        var id = rs.getInt("id");
        var city = rs.getString("city");
        var country = rs.getString("country");
        var hotelId = rs.getInt("hotel");
        var hotel = hotelDAO.findById((long) hotelId);

        return new DestinationEntity((long) id, city, country, hotel);
    }
}