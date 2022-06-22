package com.ceiba.reservation.query;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.service.ServiceGetReservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GetReservationsHandler
{
    @Autowired
    ServiceGetReservations serviceGetReservations;

    public List<ReservationSummaryDTO> implement()
    {
        return this.serviceGetReservations.implement();
    }
}