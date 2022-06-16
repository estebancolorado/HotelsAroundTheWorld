package com.ceiba.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity
{
    private Long id;
    private int numberStars;
    private List<RoomEntity> rooms;
}