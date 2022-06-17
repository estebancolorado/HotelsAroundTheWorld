package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.DestinationEntity;
import com.ceiba.adapter.repository.jdbc.DestinationDAO;
import com.ceiba.adapter.repository.jdbc.mapper.DestinationMapper;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DestinationDAOImplementation implements DestinationDAO
{
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final DestinationMapper destinationMapper;

    @SqlStatement(namespace = "destination", value = "findAllDestinations")
    private static String findAllSQL;

    @SqlStatement(namespace = "destination", value = "findDestinationById")
    private static String findByIdSQL;

    @SqlStatement(namespace = "destination", value = "saveDestination")
    private static String saveSQL;

    @SqlStatement(namespace = "destination", value = "updateDestinationById")
    private static String updateSQL;

    @SqlStatement(namespace = "destination", value = "deleteDestinationById")
    private static String deleteSQL;

    public DestinationDAOImplementation(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, DestinationMapper destinationMapper)
    {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.destinationMapper = destinationMapper;
    }

    @Override
    public List<DestinationEntity> findAll()
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.getValues();

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(findAllSQL, paramSource, destinationMapper);
    }

    @Override
    public DestinationEntity findById(Long id)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("id", id);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(findByIdSQL,paramSource, destinationMapper));
    }

    @Override
    public Long save(DestinationEntity destination, Long hotelId)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("city", destination.getCity());
        paramSource.addValue("country", destination.getCountry());
        paramSource.addValue("hotel", hotelId);

        return this.customNamedParameterJdbcTemplate.crear(paramSource, saveSQL);
    }

    @Override
    public Long update(DestinationEntity destination)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("city", destination.getCity());
        paramSource.addValue("country", destination.getCountry());
        paramSource.addValue("id", destination.getId());

        this.customNamedParameterJdbcTemplate.actualizar(paramSource, updateSQL);

        return destination.getId();
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