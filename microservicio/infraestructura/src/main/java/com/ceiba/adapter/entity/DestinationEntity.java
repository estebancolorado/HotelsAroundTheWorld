package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationEntity
{
    private Long id;
    private String city;
    private String country;
    private HotelEntity hotel;
}
