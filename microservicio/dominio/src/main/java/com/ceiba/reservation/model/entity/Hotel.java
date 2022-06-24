package com.ceiba.reservation.model.entity;

import com.ceiba.utilitarian.Constant;
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
        if(!ValidateNumber.isNumberBetween(numberStars, Constant.LOWER_LIMIT_OF_STARS, Constant.UPPER_LIMIT_OF_STARS))
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
            return Constant.MAXIMUM_LENGTH_OF_GUESTS_WITH_ONE_STAR;
        }
        else if(numberStars == 2)
        {
            return Constant.MAXIMUM_LENGTH_OF_GUESTS_WITH_TWO_STAR;
        }
        else if(numberStars == 3)
        {
            return Constant.MAXIMUM_LENGTH_OF_GUESTS_WITH_THREE_STAR;
        }
        else if(numberStars == 4)
        {
            return Constant.MAXIMUM_LENGTH_OF_GUESTS_WITH_FOUR_STAR;
        }

        return Constant.MAXIMUM_LENGTH_OF_GUESTS_WITH_FIVE_STAR;
    }
}