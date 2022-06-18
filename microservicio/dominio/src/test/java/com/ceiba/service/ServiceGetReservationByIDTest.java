package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.port.ReservationRepository;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceGetReservationByIDTest
{
    @Test
    void validateSuccessfulConsultation()
    {
        ReservationSummaryDTO reservation = new ReservationSummaryDTO();

        var repository = Mockito.mock(ReservationRepository.class);
        var calculatePrice = Mockito.mock(ServiceCalculatePrice.class);

        var service = new ServiceGetReservationByID(calculatePrice, repository);

        Mockito.when(repository.getById(Mockito.anyLong())).thenReturn(reservation);

        var reservationConsulted = service.implement(1L);

        Mockito.verify(repository, Mockito.times(1)).getById(1L);

        Assertions.assertEquals(reservation, reservationConsulted);
    }

    @Test
    void returnErrorIfDoesNotExist()
    {
        ReservationSummaryDTO reservation = new ReservationSummaryDTO();
        var repository = Mockito.mock(ReservationRepository.class);
        var calculatePrice = Mockito.mock(ServiceCalculatePrice.class);

        var service = new ServiceGetReservationByID(calculatePrice, repository);

        Mockito.when(repository.getById(1L)).thenReturn(null);

        Assertions.assertEquals(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + 1L,
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        service.implement(1L)
                ).getMessage());
    }
}