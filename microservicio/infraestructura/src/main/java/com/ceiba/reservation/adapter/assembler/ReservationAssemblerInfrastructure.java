package com.ceiba.reservation.adapter.assembler;

import com.ceiba.reservation.adapter.entity.ReservationEntity;
import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.model.entity.Reservation;

public interface ReservationAssemblerInfrastructure extends AssemblerInfrastructure<Reservation, ReservationEntity>
{
    ReservationSummaryDTO assembleDTOFromEntity(ReservationEntity entity);
}