package com.ceiba.reservation.adapter.repository.jdbc.mapper;

import com.ceiba.reservation.adapter.entity.ReservationEntity;
import com.ceiba.reservation.adapter.repository.jdbc.DestinationDAO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ReservationMapper implements RowMapper<ReservationEntity>, MapperResult
{
    @Autowired
    DestinationDAO destinationDAO;

    @Override
    public ReservationEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        var id = rs.getInt("id");
        var checkIn = rs.getString("checkin");
        var checkOut = rs.getString("checkout");
        var price = rs.getDouble("price");
        var destinationId = rs.getInt("destination");
        var destination = destinationDAO.findById((long) destinationId);

        return new ReservationEntity((long) id, checkIn, checkOut, price, destination);
    }
}
