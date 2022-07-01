package com.ceiba.reservation.controller;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.query.GetReservationByIDHandler;
import com.ceiba.reservation.query.GetReservationsHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation Controller Query")
public class ReservationControllerQuery
{
    @Autowired
    GetReservationByIDHandler getReservationByIDHandler;
    @Autowired
    GetReservationsHandler getReservationsHandler;

    @GetMapping("/{id}")
    @Operation(summary = "Get By ID", description = "This is used to get by id a reservation registered in the app")
    public ReservationSummaryDTO getById(@PathVariable Long id)
    {
        return this.getReservationByIDHandler.implement(id);
    }

    @GetMapping
    @Operation(summary = "Get All", description = "This is used to get all reservations registered in the app")
    public List<ReservationSummaryDTO> getAll()
    {
        return this.getReservationsHandler.implement();
    }
}