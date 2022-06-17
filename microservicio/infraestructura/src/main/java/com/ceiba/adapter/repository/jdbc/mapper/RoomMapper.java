package com.ceiba.adapter.repository.jdbc.mapper;

import com.ceiba.adapter.entity.RoomEntity;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RoomMapper implements RowMapper<RoomEntity>, MapperResult
{
    @Override
    public RoomEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        var id = rs.getInt("id");
        var numberGuests = rs.getInt("number_guests");

        return new RoomEntity((long) id, numberGuests);
    }
}