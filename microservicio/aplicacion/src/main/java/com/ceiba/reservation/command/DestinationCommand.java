package com.ceiba.reservation.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationCommand
{
    private String city;
    private String country;
    private HotelCommand hotel;
}