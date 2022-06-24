package com.ceiba.configuration;

import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.reservation.port.repository.ReservationRepository;
import com.ceiba.reservation.service.ServiceDeleteReservation;
import com.ceiba.reservation.service.ServiceGetReservationByID;
import com.ceiba.reservation.service.ServiceGetReservations;
import com.ceiba.reservation.service.ServiceSaveReservation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService
{
    @Bean
    public ServiceSaveReservation serviceSaveReservation(ReservationRepository reservationRepository)
    {
        return new ServiceSaveReservation(reservationRepository);
    }

    @Bean
    public ServiceDeleteReservation serviceDeleteReservation(ReservationRepository reservationRepository, ReservationQuery reservationQuery)
    {
        return new ServiceDeleteReservation(reservationRepository, reservationQuery);
    }

    @Bean
    public ServiceGetReservations serviceGetReservations(ReservationQuery reservationQuery)
    {
        return new ServiceGetReservations(reservationQuery);
    }

    @Bean
    public ServiceGetReservationByID serviceGetReservationByID(ReservationQuery reservationQuery)
    {
        return new ServiceGetReservationByID(reservationQuery);
    }
}