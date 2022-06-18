package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepository;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceDeleteReservationTest
{
    @Test
    void validateSuccessfulElimination()
    {
        ReservationSummaryDTO reservation = new ReservationSummaryDTO();

        var repository = Mockito.mock(ReservationRepository.class);

        var service = new ServiceDeleteReservation(repository);

        Mockito.when(repository.getById(Mockito.anyLong())).thenReturn(reservation);

        var id = service.implement(1L);

        Mockito.verify(repository, Mockito.times(1)).delete(1L);

        Assertions.assertEquals(0, id);
    }

    @Test
    void returnErrorIfDoesNotExist()
    {
        var repository = Mockito.mock(ReservationRepository.class);

        var service = new ServiceDeleteReservation(repository);

        Mockito.when(repository.delete(1L)).thenReturn(1L);

        Assertions.assertEquals(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + 1L,
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        service.implement(1L)
                ).getMessage());
    }
}