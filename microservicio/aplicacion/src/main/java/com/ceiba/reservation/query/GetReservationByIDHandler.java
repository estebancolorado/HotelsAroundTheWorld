package com.ceiba.reservation.query;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.service.ServiceGetReservationByID;
import org.springframework.stereotype.Component;

@Component
public class GetReservationByIDHandler
{
    private final ServiceGetReservationByID serviceGetReservationByID;

    public GetReservationByIDHandler(ServiceGetReservationByID serviceGetReservationByID)
    {
        this.serviceGetReservationByID = serviceGetReservationByID;
    }

    public ReservationSummaryDTO implement(Long id)
    {
        return this.serviceGetReservationByID.implement(id);
    }
}