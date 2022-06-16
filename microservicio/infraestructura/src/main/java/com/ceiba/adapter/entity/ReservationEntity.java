package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity
{
    private Long id;
    private String checkIn;
    private String checkOut;
    private double dollarPrice;
    private double pesosPrice;
    private DestinationEntity destination;
}