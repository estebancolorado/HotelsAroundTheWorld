package com.ceiba.model;

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

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        hotel.getRooms().forEach(item -> Assertions.assertEquals(numberOfGuests, item.getNumberGuests()));
        Assertions.assertEquals(numberOfStars, hotel.getNumberStars());
    }

    @Test
    void validateInvalidNumberOfStars()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 6;

        Assertions.assertEquals(Message.NUMBER_OF_STARS_INVALID, Assertions.assertThrows(IllegalArgumentException.class, () -> Hotel.create(numberOfStars, rooms)).getMessage());
    }

    @Test
    void validateInvalidNumberOfGuests()
    {
        var numberOfGuests = 9;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 4;

        Assertions.assertEquals(Message.UPPER_NUMBER_OF_GUESTS_INVALID + 8, Assertions.assertThrows(IllegalArgumentException.class, () -> Hotel.create(numberOfStars, rooms)).getMessage());
    }
}