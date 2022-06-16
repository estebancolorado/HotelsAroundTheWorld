package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetReservationByID
{
    @Autowired
    ServiceGetReservationByID serviceGetReservationByID;

    public ReservationSummaryDTO implement(Long id)
    {
        return this.serviceGetReservationByID.implement(id);
    }
}