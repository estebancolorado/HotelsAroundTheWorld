package com.ceiba.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.ComandoRespuesta;
import com.ceiba.reservation.controller.ReservationControllerCommand;
import com.ceiba.reservation.command.DestinationCommand;
import com.ceiba.reservation.command.HotelCommand;
import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.reservation.command.RoomCommand;
import com.ceiba.testdatabuilder.ReservationDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationControllerCommand.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReservationControllerCommandTest
{
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("It must create a reservation successful and validate if it is saved")
    void postRequestSuccessful() throws Exception
    {
        var reservation = new ReservationDTOTestDataBuilder().build();

        create(reservation);
    }

    private void create(ReservationCommand reservation) throws Exception
    {
        mocMvc.perform(MockMvcRequestBuilders.post("/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reservation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valor", is(2)));
    }

    @Test
    @DisplayName("It must throw an error when the request is wrong")
    void postRequestFailed() throws Exception
    {
        var room = new RoomCommand(3);
        var hotel = new HotelCommand(3, List.of(room));
        var destination = new DestinationCommand("Medellin", "colombia", hotel);
        var reservation = new ReservationCommand("2022/07/10", "2022/07/15", destination);

        createBadDates(reservation);
        createBadNumberOfGuests(reservation);
    }

    private void createBadDates(ReservationCommand dto) throws Exception
    {
        dto.setCheckIn("2022/07/10");
        dto.setCheckOut("2022/07/15");

        mocMvc.perform(MockMvcRequestBuilders.post("/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("FormatException")))
                .andExpect(jsonPath("$.mensaje", is("La fecha no cumple el patrón: dd/mm/yyyy")));
    }

    private void createBadNumberOfGuests(ReservationCommand dto) throws Exception
    {
        dto.getDestination().getHotel().getRooms().get(0).setNumberGuests(7);

        mocMvc.perform(MockMvcRequestBuilders.post("/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("InvalidValueException")))
                .andExpect(jsonPath("$.mensaje", is("El numero de huéspedes no puede ser mayor que 6")));
    }

    @Test
    @DisplayName("It must delete a reservation saved in the app through an identification number")
    void deleteRequestSuccessful() throws Exception
    {
        var  id = 1;

        mocMvc.perform(MockMvcRequestBuilders.delete("/reservations/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        mocMvc.perform(MockMvcRequestBuilders.get("/reservations/{i}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("It must throw an error when does not exists a reservation with an specific identification number")
    void deleteRequestFailed() throws Exception
    {
        var  id = 3;

        mocMvc.perform(MockMvcRequestBuilders.delete("/reservations/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.nombreExcepcion", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.mensaje", is("No hay reservaciones con el id " + id)));
    }
}