package com.ceiba.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.reservation.controller.ReservationControllerQuery;
import com.ceiba.testdatabuilder.ReservationDTOTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationControllerQuery.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReservationControllerQueryTest
{
    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("it must get all the reservations saved in the app")
    void getRequestSuccessful() throws Exception
    {
        var dto = new ReservationDTOTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.get("/reservations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].checkIn", is(dto.getCheckIn())))
                .andExpect(jsonPath("$[0].checkOut", is(dto.getCheckOut())))
                .andExpect(jsonPath("$[0].destination.city", is(dto.getDestination().getCity())))
                .andExpect(jsonPath("$[0].destination.country", is(dto.getDestination().getCountry())))
                .andExpect(jsonPath("$[0].destination.hotel.numberStars", is(dto.getDestination().getHotel().getNumberStars())))
                .andExpect(jsonPath("$[0].destination.hotel.rooms[0].numberGuests", is(dto.getDestination().getHotel().getRooms().get(0).getNumberGuests())));
    }

    @Test
    @DisplayName("it must throw an error when does not exist any reservation in the app")
    void getRequestFailed() throws Exception
    {
        var  id = 1;

        mocMvc.perform(MockMvcRequestBuilders.delete("/reservations/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(MockMvcRequestBuilders.get("/reservations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.mensaje", is("No hay reservaciones en la aplicación")));
    }

    @Test
    @DisplayName("it must get a reservation saved in the app by means of Identification Number")
    void getByIdRequestSuccessful() throws Exception
    {
        var dto = new ReservationDTOTestDataBuilder().build();
        var id = 1;

        mocMvc.perform(MockMvcRequestBuilders.get("/reservations/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.checkIn", is(dto.getCheckIn())))
                .andExpect(jsonPath("$.checkOut", is(dto.getCheckOut())))
                .andExpect(jsonPath("$.destination.city", is(dto.getDestination().getCity())))
                .andExpect(jsonPath("$.destination.country", is(dto.getDestination().getCountry())))
                .andExpect(jsonPath("$.destination.hotel.numberStars", is(dto.getDestination().getHotel().getNumberStars())))
                .andExpect(jsonPath("$.destination.hotel.rooms[0].numberGuests", is(dto.getDestination().getHotel().getRooms().get(0).getNumberGuests())));
    }

    @Test
    @DisplayName("it must get a reservation saved in the app by means of Identification Number")
    void getByIdRequestFailed() throws Exception
    {
        var id = 2;

        mocMvc.perform(MockMvcRequestBuilders.get("/reservations/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.mensaje", is("No hay reservaciones con el id " + id)));
    }
}