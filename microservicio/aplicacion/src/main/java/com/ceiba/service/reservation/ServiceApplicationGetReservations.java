package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ServiceApplicationGetReservations
{
    @Autowired
    ServiceGetReservations serviceGetReservations;

    public List<ReservationSummaryDTO> implement()
    {
        return this.serviceGetReservations.implement();
    }
}