package com.ceiba.model;

import com.ceiba.formatter.FormatDate;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class ReservationTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Nueva York";
        var country = "Estados Unidos de America";
        var destination = Destination.create(city, country, hotel);

        var checkIn = FormatDate.getDate("10/07/2022");
        var checkOut = FormatDate.getDate("20/07/2022");
        var reservation = Reservation.create(checkIn, checkOut, destination);

        Assertions.assertEquals(FormatDate.getDate("10/07/2022"), reservation.getCheckIn());
        Assertions.assertEquals(FormatDate.getDate("20/07/2022"), reservation.getCheckOut());
    }

    @Test
    void validateMissingFields()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Nueva York";
        var country = "Estados Unidos de America";
        var destination = Destination.create(city, country, hotel);

        var checkIn = FormatDate.getDate("10/07/2022");
        var checkOut = FormatDate.getDate("20/07/2022");

        Assertions.assertEquals(Message.INVALID_DATE_PATTERN, Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(null, checkOut, destination)).getMessage());
        Assertions.assertEquals(Message.INVALID_DATE_PATTERN, Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(checkIn, null, destination)).getMessage());
    }

    @Test
    void validateInvalidCheckInDate()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Nueva York";
        var country = "Estados Unidos de America";
        var destination = Destination.create(city, country, hotel);

        var checkIn = FormatDate.getDate("14/06/2022");
        var checkOut = FormatDate.getDate("20/07/2022");

        Assertions.assertEquals(Message.CHECKIN_CANNOT_BE_LESS_THAN_TODAY, Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(checkIn, checkOut, destination)).getMessage());
    }

    @Test
    void validateInvalidCheckOutDate()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Nueva York";
        var country = "Estados Unidos de America";
        var destination = Destination.create(city, country, hotel);

        var checkIn = FormatDate.getDate("10/07/2022");
        var checkOut = FormatDate.getDate("10/07/2022");

        Assertions.assertEquals(Message.CHECKOUT_CANNOT_BE_LESS_THAN_OR_EQUAL_CHECKIN, Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(checkIn, checkOut, destination)).getMessage());
    }
}