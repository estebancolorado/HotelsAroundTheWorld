package com.ceiba.service;

import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepositoryCommand;
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

        var repository = Mockito.mock(ReservationRepositoryCommand.class);
        var calculatePrice = Mockito.mock(ServiceCalculatePrice.class);

        var service = new ServiceSaveReservation(calculatePrice, repository);

        Mockito.when(repository.save(Mockito.any(Reservation.class), Mockito.any(double.class))).thenReturn(1L);

        var summaryDTO = service.implement(reservation);

        Mockito.verify(repository, Mockito.times(1)).save(reservation, summaryDTO.getDollarPrice());

        Assertions.assertEquals(1L, summaryDTO.getId());
    }
}