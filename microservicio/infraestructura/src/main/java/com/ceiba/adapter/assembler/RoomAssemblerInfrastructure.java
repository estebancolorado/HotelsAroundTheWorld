package com.ceiba.adapter.assembler;

import com.ceiba.adapter.entity.RoomEntity;
import com.ceiba.model.Room;
import java.util.List;

public interface RoomAssemblerInfrastructure extends AssemblerInfrastructure<Room, RoomEntity>
{
    List<Room> assembleDomainsFromEntities(List<RoomEntity> entities);
    List<RoomEntity> assembleEntitiesFromDomains(List<Room> domains);
}