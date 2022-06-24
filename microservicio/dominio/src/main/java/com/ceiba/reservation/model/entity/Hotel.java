package com.ceiba.reservation.model.entity;

import com.ceiba.utilitarian.Message;
import com.ceiba.validator.ValidateNumber;
import lombok.Getter;
import java.util.List;

@Getter
public final class Hotel
{
    private int numberStars;
    private List<Room> rooms;

    private Hotel(int numberStars, List<Room> rooms)
    {
        setNumberStars(numberStars);
        setRooms(rooms);
    }

    public static Hotel create(int numberStars, List<Room> rooms)
    {
        return new Hotel(numberStars, rooms);
    }

    private void setNumberStars(int numberStars)
    {
        if(!ValidateNumber.isNumberBetween(numberStars, 1, 5))
        {
            throw new IllegalArgumentException(Message.NUMBER_OF_STARS_INVALID);
        }

        this.numberStars = numberStars;
    }

    private void setRooms(List<Room> rooms)
    {
        int guestsAllowed = calculateNumberGuestsAllowed(this.numberStars);

        rooms.forEach(room ->
        {
            if(room.getNumberGuests() > guestsAllowed)
            {
                throw new IllegalArgumentException(Message.UPPER_NUMBER_OF_GUESTS_INVALID + guestsAllowed);
            }
        });

        this.rooms = List.copyOf(rooms);
    }

    private int calculateNumberGuestsAllowed(int numberStars)
    {
        if(numberStars == 1)
        {
            return 4;
        }
        else if(numberStars == 2)
        {
            return 5;
        }
        else if(numberStars == 3)
        {
            return 6;
        }
        else if(numberStars == 4)
        {
            return 8;
        }

        return 10;
    }
}