package com.ceiba.controller;

import com.ceiba.controller.response.Response;
import com.ceiba.controller.response.StatusResponse;
import com.ceiba.dto.ReservationDTO;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.service.ServiceApplicationDeleteReservation;
import com.ceiba.service.ServiceApplicationSaveReservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservation Controller Command")
public class ReservationControllerCommand
{
    @Autowired
    ServiceApplicationSaveReservation serviceSaveReservation;
    @Autowired
    ServiceApplicationDeleteReservation serviceDeleteReservation;

    @PostMapping
    @Operation(summary = "Save Reservation", description = "This is used to save a reservation in the app")
    public Response<ReservationSummaryDTO> save(@RequestBody ReservationDTO reservation)
    {
        Response<ReservationSummaryDTO> response = new Response<>();

        response.setData(List.of(this.serviceSaveReservation.implement(reservation)));

        response.addMessage("The reservation was saved successful");

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Reservation", description = "This is used to delete a reservation in the app using an ID")
    public Response<Long> delete(@PathVariable Long id)
    {
        Response<Long> response = new Response<>();

        response.setData(List.of(this.serviceDeleteReservation.implement(id)));

        response.addMessage("The reservation was deleted successful");

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }
}