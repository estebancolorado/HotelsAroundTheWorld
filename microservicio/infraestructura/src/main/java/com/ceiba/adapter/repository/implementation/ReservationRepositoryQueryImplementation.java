package com.ceiba.adapter.repository.implementation;

import com.ceiba.adapter.repository.jdbc.ReservationDAO;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepositoryQuery;
import com.ceiba.validator.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.ceiba.adapter.assembler.implementation.ReservationAssemblerInfrastructureImplementation.getReservationAssembler;

@Repository
public class ReservationRepositoryQueryImplementation implements ReservationRepositoryQuery
{
    @Autowired
    ReservationDAO reservationDAO;

    @Override
    public List<ReservationSummaryDTO> getAll()
    {
        return this.reservationDAO.findAll().stream().map(getReservationAssembler()::assembleDTOFromEntity).toList();
    }

    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        var entity = this.reservationDAO.findById(id);

        if(ValidateObject.isNull(entity))
        {
            return null;
        }

        return getReservationAssembler().assembleDTOFromEntity(entity);
    }
}