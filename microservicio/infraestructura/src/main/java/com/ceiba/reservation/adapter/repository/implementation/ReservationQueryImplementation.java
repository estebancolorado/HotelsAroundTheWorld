package com.ceiba.reservation.adapter.repository.implementation;

import com.ceiba.reservation.adapter.repository.jdbc.ReservationDAO;
import com.ceiba.reservation.adapter.assembler.implementation.ReservationAssemblerInfrastructureImplementation;
import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.validator.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationQueryImplementation implements ReservationQuery
{
    @Autowired
    ReservationDAO reservationDAO;

    @Override
    public List<ReservationSummaryDTO> getAll()
    {
        return this.reservationDAO.findAll().stream().map(ReservationAssemblerInfrastructureImplementation.getReservationAssembler()::assembleDTOFromEntity).toList();
    }

    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        var entity = this.reservationDAO.findById(id);

        if(ValidateObject.isNull(entity))
        {
            return null;
        }

        return ReservationAssemblerInfrastructureImplementation.getReservationAssembler().assembleDTOFromEntity(entity);
    }
}