package com.ceiba.model;

import com.ceiba.dominio.excepcion.InvalidValueException;
import com.ceiba.reservation.model.entity.Hotel;
import com.ceiba.reservation.model.entity.Room;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class HotelTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var hotelCaseOne = Hotel.create(1, rooms);
        var hotelCaseTwo = Hotel.create(2, rooms);
        var hotelCaseThree = Hotel.create(3, rooms);
        var hotelCaseFour = Hotel.create(4, rooms);
        var hotelCaseFive = Hotel.create(5, rooms);

        hotelCaseOne.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(1, hotelCaseOne.getNumberStars());

        hotelCaseTwo.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(2, hotelCaseTwo.getNumberStars());

        hotelCaseThree.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(3, hotelCaseThree.getNumberStars());

        hotelCaseFour.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(4, hotelCaseFour.getNumberStars());

        hotelCaseFive.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(5, hotelCaseFive.getNumberStars());
    }

    @Test
    void validateInvalidNumberOfStars()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 6;

        Assertions.assertEquals(Message.NUMBER_OF_STARS_INVALID, Assertions.assertThrows(InvalidValueException.class, () -> Hotel.create(numberOfStars, rooms)).getMessage());
    }

    @Test
    void validateInvalidNumberOfGuests()
    {
        var numberOfGuests = 9;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 4;

        Assertions.assertEquals(Message.UPPER_NUMBER_OF_GUESTS_INVALID + 8, Assertions.assertThrows(InvalidValueException.class, () -> Hotel.create(numberOfStars, rooms)).getMessage());
    }
}