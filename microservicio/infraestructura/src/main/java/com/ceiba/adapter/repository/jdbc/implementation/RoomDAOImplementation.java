package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.RoomEntity;
import com.ceiba.adapter.repository.jdbc.RoomDAO;
import com.ceiba.adapter.repository.jdbc.mapper.RoomMapper;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RoomDAOImplementation implements RoomDAO
{
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final RoomMapper roomMapper;

    public RoomDAOImplementation(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RoomMapper roomMapper)
    {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.roomMapper = roomMapper;
    }

    @SqlStatement(namespace = "room", value = "findAllRooms")
    private static String findAllSQL;

    @SqlStatement(namespace = "room", value = "findRoomById")
    private static String findByIdSQL;

    @SqlStatement(namespace = "room", value = "saveRoom")
    private static String saveSQL;

    @SqlStatement(namespace = "room", value = "deleteRoomById")
    private static String deleteSQL;

    @Override
    public List<RoomEntity> findAll(Long hotelId)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("hotel", hotelId);
        paramSource.getValues();

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(findAllSQL, paramSource, roomMapper);
    }

    @Override
    public RoomEntity findById(Long id)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(findByIdSQL,paramSource, roomMapper));
    }

    @Override
    public Long save(RoomEntity room, Long hotelId)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("number_guests", room.getNumberGuests());
        paramSource.addValue("hotel", hotelId);

        return this.customNamedParameterJdbcTemplate.crear(paramSource, saveSQL);
    }

    @Override
    public Long delete(Long id)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("id", id);

        EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(deleteSQL,paramSource));

        return id;
    }
}