package com.ceiba.reservation.model.dto;

import com.ceiba.reservation.model.entity.Destination;
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
    private double price;
    private Destination destination;
}