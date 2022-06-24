package com.ceiba.service;

import com.ceiba.reservation.model.entity.Reservation;
import com.ceiba.reservation.port.repository.ReservationRepository;
import com.ceiba.reservation.service.ServiceSaveReservation;
import com.ceiba.testdatabuilder.ReservationTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceSaveReservationTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var reservation = new ReservationTestDataBuilder().build();

        var repository = Mockito.mock(ReservationRepository.class);

        var service = new ServiceSaveReservation(repository);

        Mockito.when(repository.save(Mockito.any(Reservation.class), Mockito.any(double.class))).thenReturn(1L);

        var id = service.implement(reservation);

        Mockito.verify(repository, Mockito.times(1)).save(reservation, reservation.calculatePrice());

        Assertions.assertEquals(1L, id);
    }
}