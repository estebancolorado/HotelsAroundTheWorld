package com.ceiba.reservation.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCommand
{
    private String checkIn;
    private String checkOut;
    private DestinationCommand destination;
}