package com.ceiba.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.reservation.service.ServiceGetReservationByID;
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

        var repositoryQuery = Mockito.mock(ReservationQuery.class);

        var service = new ServiceGetReservationByID(repositoryQuery);

        Mockito.when(repositoryQuery.getById(Mockito.anyLong())).thenReturn(reservation);

        var reservationConsulted = service.implement(1L);

        Mockito.verify(repositoryQuery, Mockito.times(1)).getById(1L);

        Assertions.assertEquals(reservation, reservationConsulted);
    }

    @Test
    void returnErrorIfDoesNotExist()
    {
        ReservationSummaryDTO reservation = new ReservationSummaryDTO();
        var repositoryQuery = Mockito.mock(ReservationQuery.class);

        var service = new ServiceGetReservationByID(repositoryQuery);

        Mockito.when(repositoryQuery.getById(1L)).thenReturn(null);

        Assertions.assertEquals(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + 1L,
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        service.implement(1L)
                ).getMessage());
    }
}