package com.ceiba.controller;

import com.ceiba.controller.response.Response;
import com.ceiba.controller.response.StatusResponse;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.service.ServiceApplicationGetReservationByID;
import com.ceiba.service.ServiceApplicationGetReservations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservation Controller Query")
public class ReservationControllerQuery
{
    @Autowired
    ServiceApplicationGetReservationByID serviceGetReservationByID;
    @Autowired
    ServiceApplicationGetReservations serviceGetReservations;

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