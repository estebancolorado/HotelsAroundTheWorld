package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class HotelEntity
{
    private Long id;
    private int numberStars;
    private List<RoomEntity> rooms;
}