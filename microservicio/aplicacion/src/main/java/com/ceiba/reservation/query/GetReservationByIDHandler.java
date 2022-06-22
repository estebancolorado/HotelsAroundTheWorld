package com.ceiba.reservation.query;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.service.ServiceGetReservationByID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetReservationByIDHandler
{
    @Autowired
    ServiceGetReservationByID serviceGetReservationByID;

    public ReservationSummaryDTO implement(Long id)
    {
        return this.serviceGetReservationByID.implement(id);
    }
}