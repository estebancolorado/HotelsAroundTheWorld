package com.ceiba.service;

import com.ceiba.testdatabuilder.ReservationTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceCalculatePriceTest
{
    @Test
    void validateSuccessfulPriceCalculation()
    {
        var reservation = new ReservationTestDataBuilder().build();
        var numberStars = reservation.getDestination().getHotel().getNumberStars();
        var rooms = reservation.getDestination().getHotel().getRooms();
        var checkIn = reservation.getCheckIn();
        var checkOut = reservation.getCheckOut();

        var service = new ServiceCalculatePrice();

        Assertions.assertEquals(8112.0, service.calculatePrice(numberStars, rooms, checkIn, checkOut));
    }

    @Test
    void validateSuccessfulCurrencyCalculation()
    {
        var dollarPrice = 10;
        var service = new ServiceCalculatePrice();

        Assertions.assertEquals(39016.7, service.calculateCurrency(dollarPrice));
    }
}