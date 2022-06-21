package com.ceiba.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.controller.response.Response;
import com.ceiba.dto.ReservationDTO;
import com.ceiba.port.ReservationRepository;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReservationControllerTest
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

    private void create(ReservationDTO dto) throws Exception
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
    @DisplayName("it must get all the reservations saved in the app")
    void getRequestSuccessful() throws Exception
    {
        var dto = new ReservationDTOTestDataBuilder().build();

        mocMvc.perform(MockMvcRequestBuilders.get("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("SUCCESSFUL")))
                .andExpect(jsonPath("$.messages[0]", is("The reservations was consulted successful")))
                .andExpect(jsonPath("$.data[0].checkIn", is(dto.getCheckIn())))
                .andExpect(jsonPath("$.data[0].checkOut", is(dto.getCheckOut())))
                .andExpect(jsonPath("$.data[0].destination.city", is(dto.getDestination().getCity())))
                .andExpect(jsonPath("$.data[0].destination.country", is(dto.getDestination().getCountry())))
                .andExpect(jsonPath("$.data[0].destination.hotel.numberStars", is(dto.getDestination().getHotel().getNumberStars())))
                .andExpect(jsonPath("$.data[0].destination.hotel.rooms[0].numberGuests", is(dto.getDestination().getHotel().getRooms().get(0).getNumberGuests())));
    }

    @Test
    @DisplayName("it must get a reservation saved in the app by means of Identification Number")
    void getByIdRequestSuccessful() throws Exception
    {
        var dto = new ReservationDTOTestDataBuilder().build();
        var id = 1;

        mocMvc.perform(MockMvcRequestBuilders.get("/api/reservations/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("SUCCESSFUL")))
                .andExpect(jsonPath("$.messages[0]", is("The reservation with the id " + id + " was consulted successful")))
                .andExpect(jsonPath("$.data[0].checkIn", is(dto.getCheckIn())))
                .andExpect(jsonPath("$.data[0].checkOut", is(dto.getCheckOut())))
                .andExpect(jsonPath("$.data[0].destination.city", is(dto.getDestination().getCity())))
                .andExpect(jsonPath("$.data[0].destination.country", is(dto.getDestination().getCountry())))
                .andExpect(jsonPath("$.data[0].destination.hotel.numberStars", is(dto.getDestination().getHotel().getNumberStars())))
                .andExpect(jsonPath("$.data[0].destination.hotel.rooms[0].numberGuests", is(dto.getDestination().getHotel().getRooms().get(0).getNumberGuests())));
    }
}