package com.ceiba.model;

import com.ceiba.dominio.excepcion.LengthException;
import com.ceiba.dominio.excepcion.WithOutDataException;
import com.ceiba.reservation.model.entity.Destination;
import com.ceiba.reservation.model.entity.Hotel;
import com.ceiba.reservation.model.entity.Room;
import com.ceiba.utilitarian.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class DestinationTest
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

        Assertions.assertEquals("Nueva York", destination.getCity());
        Assertions.assertEquals("Estados Unidos de America", destination.getCountry());
        Assertions.assertEquals(3, destination.getHotel().getNumberStars());
    }

    @Test
    void validateMissingFields()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        Assertions.assertEquals(Message.CITY_CANNOT_BE_EMPTY, Assertions.assertThrows(WithOutDataException.class, () -> Destination.create(null, "Estados Unidos de America", hotel)).getMessage());
        Assertions.assertEquals(Message.COUNTRY_CANNOT_BE_EMPTY, Assertions.assertThrows(WithOutDataException.class, () -> Destination.create("Nueva York", null, hotel)).getMessage());
    }

    @Test
    void validateEmptyFields()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        Assertions.assertEquals(Message.CITY_CANNOT_BE_EMPTY, Assertions.assertThrows(WithOutDataException.class, () -> Destination.create("", "Estados Unidos de America", hotel)).getMessage());
        Assertions.assertEquals(Message.COUNTRY_CANNOT_BE_EMPTY, Assertions.assertThrows(WithOutDataException.class, () -> Destination.create("Nueva York", "", hotel)).getMessage());
    }

    @Test
    void validateInvalidCityLength()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Taumatawhakatangihangak oauauotamateaturipukaka pikimaungahoronukupokaiwhe nua kitanatahut";
        var country = "Nueva Zelanda";

        Assertions.assertEquals(Message.INVALID_CITY_LENGTH, Assertions.assertThrows(LengthException.class, () -> Destination.create(city, country, hotel)).getMessage());
    }

    @Test
    void validateInvalidCountryLength()
    {
        var numberOfGuests = 2;
        var room = Room.create(numberOfGuests);
        var rooms = List.of(room);

        var numberOfStars = 3;
        var hotel = Hotel.create(numberOfStars, rooms);

        var city = "Belfast";
        var country = "Reino Unido de Gran Breta??a e Irlanda del Norte y la Union Europea";

        Assertions.assertEquals(Message.INVALID_COUNTRY_LENGTH, Assertions.assertThrows(LengthException.class, () -> Destination.create(city, country, hotel)).getMessage());
    }
}