package com.ceiba.controller;

import com.ceiba.controller.response.Response;
import com.ceiba.controller.response.StatusResponse;
import com.ceiba.dto.ReservationDTO;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.service.reservation.ServiceApplicationDeleteReservation;
import com.ceiba.service.reservation.ServiceApplicationGetReservationByID;
import com.ceiba.service.reservation.ServiceApplicationGetReservations;
import com.ceiba.service.reservation.ServiceApplicationSaveReservation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservation Controller")
public class ReservationController
{
    @Autowired
    ServiceApplicationSaveReservation serviceSaveReservation;
    @Autowired
    ServiceApplicationDeleteReservation serviceDeleteReservation;
    @Autowired
    ServiceApplicationGetReservationByID serviceGetReservationByID;
    @Autowired
    ServiceApplicationGetReservations serviceGetReservations;

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

    @GetMapping("/{id}")
    @Operation(summary = "Get By ID", description = "This is used to get by id a reservation registered in the app")
    public Response<ReservationSummaryDTO> getById(@PathVariable Long id)
    {
        Response<ReservationSummaryDTO> response = new Response<>();

        response.setData(List.of(this.serviceGetReservationByID.implement(id)));

        response.addMessage("The reservation with the id " + id + " was consulted successful");

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }

    @GetMapping
    @Operation(summary = "Get All", description = "This is used to get all reservations registered in the app")
    public Response<ReservationSummaryDTO> getAll()
    {
        Response<ReservationSummaryDTO> response = new Response<>();

        response.setData(this.serviceGetReservations.implement());

        response.addMessage("The reservations was consulted successful");

        response.setStatus(StatusResponse.SUCCESSFUL);

        return response;
    }
}