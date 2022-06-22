package com.ceiba.reservation.adapter.assembler;

import com.ceiba.reservation.adapter.entity.RoomEntity;
import com.ceiba.reservation.model.entity.Room;
import java.util.List;

public interface RoomAssemblerInfrastructure extends AssemblerInfrastructure<Room, RoomEntity>
{
    List<Room> assembleDomainsFromEntities(List<RoomEntity> entities);
    List<RoomEntity> assembleEntitiesFromDomains(List<Room> domains);
}