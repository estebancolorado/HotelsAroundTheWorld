package com.ceiba.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.reservation.service.ServiceGetReservations;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class ServiceGetReservationsTest
{
    @Test
    void validateSuccessfulConsultation()
    {
        var reservations = List.of( new ReservationSummaryDTO());
        var repository = Mockito.mock(ReservationQuery.class);

        var service = new ServiceGetReservations(repository);

        Mockito.when(repository.getAll()).thenReturn(reservations);

        var reservationConsulted = service.implement();

        Mockito.verify(repository, Mockito.times(1)).getAll();

        Assertions.assertEquals(reservations, reservationConsulted);
    }

    @Test
    void returnErrorIfDoesNotExist()
    {
        List<ReservationSummaryDTO> reservations = new ArrayList<>();

        var repository = Mockito.mock(ReservationQuery.class);

        var service = new ServiceGetReservations(repository);

        Mockito.when(repository.getAll()).thenReturn(new ArrayList<>());

        Assertions.assertEquals(Message.THERE_IS_NOT_RESERVATIONS, Assertions.assertThrows(IllegalArgumentException.class, service::implement).getMessage());
    }
}