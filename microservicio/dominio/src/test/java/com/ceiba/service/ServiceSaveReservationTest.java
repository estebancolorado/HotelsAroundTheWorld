package com.ceiba.service;

import com.ceiba.reservation.model.entity.Reservation;
import com.ceiba.reservation.port.repository.ReservationRepository;
import com.ceiba.reservation.service.ServiceSaveReservation;
import com.ceiba.testdatabuilder.ReservationTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ServiceSaveReservationTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var reservation = new ReservationTestDataBuilder().build();

        var repository = Mockito.mock(ReservationRepository.class);

        var service = new ServiceSaveReservation(repository);

        Mockito.when(repository.save(Mockito.any(Reservation.class))).thenReturn(1L);

        var id = service.implement(reservation);

        Mockito.verify(repository, Mockito.times(1)).save(reservation);

        Assertions.assertEquals(1L, id);
        Assertions.assertEquals(8112.0, reservation.getPrice());
    }
}