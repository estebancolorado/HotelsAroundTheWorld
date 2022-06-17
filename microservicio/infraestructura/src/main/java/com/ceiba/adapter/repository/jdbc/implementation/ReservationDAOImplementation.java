package com.ceiba.adapter.repository.jdbc.implementation;

import com.ceiba.adapter.entity.ReservationEntity;
import com.ceiba.adapter.repository.jdbc.ReservationDAO;
import com.ceiba.adapter.repository.jdbc.mapper.ReservationMapper;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.validator.ValidateObject;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationDAOImplementation implements ReservationDAO
{
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final ReservationMapper reservationMapper;

    @SqlStatement(namespace = "reservation", value = "findAllReservations")
    private static String findAllSQL;

    @SqlStatement(namespace = "reservation", value = "findReservationById")
    private static String findByIdSQL;

    @SqlStatement(namespace = "reservation", value = "saveReservation")
    private static String saveSQL;

    @SqlStatement(namespace = "reservation", value = "updateReservationById")
    private static String updateSQL;

    @SqlStatement(namespace = "reservation", value = "deleteReservationById")
    private static String deleteSQL;

    public ReservationDAOImplementation(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, ReservationMapper reservationMapper)
    {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<ReservationEntity> findAll()
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.getValues();

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(findAllSQL, paramSource, reservationMapper);
    }

    @Override
    public ReservationEntity findById(Long id)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("id", id);

        var reservation = EjecucionBaseDeDatos.obtenerUnObjetoONull(()-> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(findByIdSQL,paramSource, reservationMapper));

        if(ValidateObject.isNull(reservation))
        {
            return null;
        }

        return reservation;
    }

    @Override
    public Long save(ReservationEntity reservation, Long destinationId)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("checkin", reservation.getCheckIn());
        paramSource.addValue("checkout", reservation.getCheckOut());
        paramSource.addValue("price", reservation.getPrice());
        paramSource.addValue("destination", destinationId);

        return this.customNamedParameterJdbcTemplate.crear(paramSource, saveSQL);
    }

    @Override
    public Long update(ReservationEntity reservation)
    {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();

        paramSource.addValue("checkin", reservation.getCheckIn());
        paramSource.addValue("checkout", reservation.getCheckOut());
        paramSource.addValue("price", reservation.getPrice());
        paramSource.addValue("id", reservation.getId());

        this.customNamedParameterJdbcTemplate.actualizar(paramSource, updateSQL);

        return reservation.getId();
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