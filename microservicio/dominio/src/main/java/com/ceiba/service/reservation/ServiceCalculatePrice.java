package com.ceiba.service.reservation;

import com.ceiba.model.Room;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ServiceCalculatePrice
{
    private static final double VALUE_OF_DOLLAR_IN_PESOS = 3901.67;

    public double calculatePrice(int numberStars, List<Room> rooms, LocalDate checkIn, LocalDate checkOut)
    {
        double finalPrice = 100.0;

        if(numberStars > 1)
        {
            for(int i = 0; i < numberStars - 1; i++)
            {
                finalPrice = finalPrice + (finalPrice * 0.30);
            }
        }

        if(rooms.size() > 1)
        {
            for(int i = 0; i < rooms.size() - 1; i++)
            {
                finalPrice = finalPrice + (finalPrice * 0.20);
            }
        }

        for(int i = 0; i < rooms.size(); i++)
        {
            finalPrice = finalPrice * rooms.get(0).getNumberGuests();
        }

        long days = ChronoUnit.DAYS.between(checkIn, checkOut);

        finalPrice = finalPrice * days;

        return Math.round(finalPrice*100.0)/100.0;
    }

    public double calculateCurrency(double dollarPrice)
    {
        return Math.round((dollarPrice * VALUE_OF_DOLLAR_IN_PESOS)*100.0)/100.0;
    }
}