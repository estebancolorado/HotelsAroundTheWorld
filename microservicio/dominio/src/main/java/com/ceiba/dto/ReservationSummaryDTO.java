package com.ceiba.dto;

import com.ceiba.model.Destination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationSummaryDTO
{
    private Long id;
    private String checkIn;
    private String checkOut;
    private double dollarPrice;
    private double pesosPrice;
    private Destination destination;
}