package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationEntity
{
    private Long id;
    private String checkIn;
    private String checkOut;
    private double price;
    private DestinationEntity destination;
}