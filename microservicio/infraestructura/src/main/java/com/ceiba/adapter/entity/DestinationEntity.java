package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DestinationEntity
{
    private Long id;
    private String city;
    private String country;
    private HotelEntity hotel;
}
