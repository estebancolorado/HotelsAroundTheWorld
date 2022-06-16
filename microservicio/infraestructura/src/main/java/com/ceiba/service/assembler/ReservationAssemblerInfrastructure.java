package com.ceiba.service.assembler;

import com.ceiba.adapter.entity.ReservationEntity;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;

public interface ReservationAssemblerInfrastructure extends AssemblerInfrastructure<Reservation, ReservationEntity>
{
    ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity);
}