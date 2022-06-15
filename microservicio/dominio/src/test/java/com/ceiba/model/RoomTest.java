package com.ceiba.model;

import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoomTest
{
    @Test
    void validateSuccessfulCreation()
    {
        int numberOfGuests = 2;

        var room = Room.create(numberOfGuests);

        Assertions.assertEquals(numberOfGuests, room.getNumberGuests());
    }

    @Test
    void validateInvalidNumberOfGuests()
    {
        int numberOfGuests = 0;

        Assertions.assertEquals(Message.LOWER_NUMBER_OF_GUESTS_INVALID, Assertions.assertThrows(IllegalArgumentException.class, () -> Room.create(numberOfGuests)).getMessage());
    }
}