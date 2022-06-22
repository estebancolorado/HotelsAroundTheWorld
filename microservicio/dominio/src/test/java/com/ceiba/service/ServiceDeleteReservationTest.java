package com.ceiba.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.port.repository.ReservationRepository;
import com.ceiba.reservation.port.dao.ReservationQuery;
import com.ceiba.reservation.service.ServiceDeleteReservation;
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

        var repositoryCommand = Mockito.mock(ReservationRepository.class);
        var repositoryQuery = Mockito.mock(ReservationQuery.class);

        var service = new ServiceDeleteReservation(repositoryCommand, repositoryQuery);

        Mockito.when(repositoryQuery.getById(Mockito.anyLong())).thenReturn(reservation);

        var id = service.implement(1L);

        Mockito.verify(repositoryCommand, Mockito.times(1)).delete(1L);

        Assertions.assertEquals(0, id);
    }

    @Test
    void returnErrorIfDoesNotExist()
    {
        var repositoryCommand = Mockito.mock(ReservationRepository.class);
        var repositoryQuery = Mockito.mock(ReservationQuery.class);

        var service = new ServiceDeleteReservation(repositoryCommand, repositoryQuery);

        Mockito.when(repositoryCommand.delete(1L)).thenReturn(1L);

        Assertions.assertEquals(Message.RESERVATION_DOES_NOT_EXISTS_WITH_ID + 1L, Assertions.assertThrows(IllegalArgumentException.class, () -> service.implement(1L)).getMessage());
    }
}