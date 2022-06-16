package com.ceiba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO
{
    private String city;
    private String country;
    private HotelDTO hotel;
}