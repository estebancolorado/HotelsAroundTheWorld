package com.ceiba.reservation.query;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.service.ServiceGetReservations;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GetReservationsHandler
{
    private final ServiceGetReservations serviceGetReservations;

    public GetReservationsHandler(ServiceGetReservations serviceGetReservations)
    {
        this.serviceGetReservations = serviceGetReservations;
    }

    public List<ReservationSummaryDTO> implement()
    {
        return this.serviceGetReservations.implement();
    }
}