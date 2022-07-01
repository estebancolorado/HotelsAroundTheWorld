package com.ceiba.reservation.model.entity;

import com.ceiba.dominio.excepcion.InvalidValueException;
import com.ceiba.utilitarian.Constant;
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
        if(ValidateNumber.isNumberLessThanOrEqual(numberGuests, Constant.MINIMUM_LENGTH_OF_GUESTS))
        {
            throw new InvalidValueException(Message.LOWER_NUMBER_OF_GUESTS_INVALID);
        }

        this.numberGuests = numberGuests;
    }
}