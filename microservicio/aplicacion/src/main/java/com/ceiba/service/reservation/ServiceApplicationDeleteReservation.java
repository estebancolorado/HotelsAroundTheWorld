package com.ceiba.service.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteReservation
{
    @Autowired
    ServiceDeleteReservation serviceDeleteReservation;

    public void implement(Long id)
    {
        this.serviceDeleteReservation.implement(id);
    }
}