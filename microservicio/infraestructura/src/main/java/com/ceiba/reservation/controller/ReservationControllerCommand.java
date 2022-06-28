package com.ceiba.reservation.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.reservation.command.handler.DeleteReservationHandler;
import com.ceiba.reservation.command.handler.SaveReservationHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservation Controller Command")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationControllerCommand
{
    private final SaveReservationHandler saveReservationHandler;
    private final DeleteReservationHandler deleteReservationHandler;

    public ReservationControllerCommand(SaveReservationHandler saveReservationHandler, DeleteReservationHandler deleteReservationHandler)
    {
        this.saveReservationHandler = saveReservationHandler;
        this.deleteReservationHandler = deleteReservationHandler;
    }

    @PostMapping
    @Operation(summary = "Save Reservation", description = "This is used to save a reservation in the app")
    public ComandoRespuesta<Long> save(@RequestBody ReservationCommand reservation)
    {
        return this.saveReservationHandler.ejecutar(reservation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Reservation", description = "This is used to delete a reservation in the app using an ID")
    public void delete(@PathVariable Long id)
    {
        this.deleteReservationHandler.ejecutar(id);
    }
}