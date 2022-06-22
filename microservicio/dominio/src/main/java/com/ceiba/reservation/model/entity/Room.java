package com.ceiba.reservation.model.entity;

import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateNumber;
import lombok.Getter;

@Getter
public final class Room
{
    private int numberGuests;

    private Room(int numberGuests)
    {
        setNumberGuests(numberGuests);
    }

    public static Room create(int numberGuests)
    {
        return new Room(numberGuests);
    }

    private void setNumberGuests(int numberGuests)
    {
        if(ValidateNumber.isNumberLessThanOrEqual(numberGuests, 0))
        {
            throw new IllegalArgumentException(Message.LOWER_NUMBER_OF_GUESTS_INVALID);
        }

        this.numberGuests = numberGuests;
    }
}