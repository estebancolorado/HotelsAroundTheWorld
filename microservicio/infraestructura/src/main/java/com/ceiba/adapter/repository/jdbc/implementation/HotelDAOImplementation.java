package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.HotelEntity;
import com.ceiba.adapter.repository.jdbc.HotelDAO;
import com.ceiba.adapter.repository.jdbc.mapper.HotelMapper;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDAOImplementation implements HotelDAO
{
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final HotelMapper hotelMapper;
    public HotelDAOImplementation(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, HotelMapper hotelMapper)
    {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.hotelMapper = hotelMapper;
    }

    @SqlStatement(namespace = "hotel", value = "findHotelById")
    private static String findByIdSQL;

    @SqlStatement(namespace = "hotel", value = "saveHotel")
    private static String saveSQL;
    @SqlStatement(namespace = "hotel", value = "deleteHotelById")
    private static String deleteSQL;

    @Override
    public HotelEntity findById(Long id)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(findByIdSQL,paramSource, hotelMapper));
    }

    @Override
    public Long save(HotelEntity hotel)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("number_stars", hotel.getNumberStars());

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