package com.ceiba.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.reservation.controller.ReservationControllerCommand;
import com.ceiba.reservation.controller.response.Response;
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
        var dto = new ReservationDTOTestDataBuilder().build();

        create(dto);
    }

    private void create(ReservationCommand dto) throws Exception
    {
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        var response = objectMapper.readValue(jsonResult, Response.class);

        var message = response.getMessages().get(0);
        Assertions.assertEquals("The reservation was saved successful", message);
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

        mocMvc.perform(MockMvcRequestBuilders.post("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.nameException", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.message", is("Date has not the pattern dd/mm/yyyy")));
    }

    private void createBadNumberOfGuests(ReservationCommand dto) throws Exception
    {
        dto.getDestination().getHotel().getRooms().get(0).setNumberGuests(7);

        mocMvc.perform(MockMvcRequestBuilders.post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.nameException", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.message", is("Number of guests cannot be greater than 6")));
    }

    @Test
    @DisplayName("It must delete a reservation saved in the app through an identification number")
    void deleteRequestSuccessful() throws Exception
    {
        var  id = 1;

        var result = mocMvc.perform(MockMvcRequestBuilders.delete("/api/reservations/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        var jsonResult = result.getResponse().getContentAsString();
        var response = objectMapper.readValue(jsonResult, Response.class);

        var message = response.getMessages().get(0);
        var data = response.getData().get(0);

        Assertions.assertEquals("The reservation was deleted successful", message);
        Assertions.assertEquals(data, id);
    }

    @Test
    @DisplayName("It must throw an error when does not exists a reservation with an specific identification number")
    void deleteRequestFailed() throws Exception
    {
        var  id = 2;

        mocMvc.perform(MockMvcRequestBuilders.delete("/api/reservations/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.nameException", is("IllegalArgumentException")))
                .andExpect(jsonPath("$.message", is("There is no reservation on id " + id)));
    }
}