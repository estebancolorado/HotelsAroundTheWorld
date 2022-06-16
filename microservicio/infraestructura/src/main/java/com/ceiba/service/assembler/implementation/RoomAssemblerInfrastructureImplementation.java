package com.ceiba.service.assembler.implementation;

import com.ceiba.adapter.entity.RoomEntity;
import com.ceiba.model.Room;
import com.ceiba.service.assembler.RoomAssemblerInfrastructure;
import java.util.List;

public class RoomAssemblerInfrastructureImplementation implements RoomAssemblerInfrastructure
{
    private static final RoomAssemblerInfrastructure INSTANCE = new RoomAssemblerInfrastructureImplementation();

    private RoomAssemblerInfrastructureImplementation()
    {

    }

    public static RoomAssemblerInfrastructure getRoomAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Room assembleDomainFromEntity(RoomEntity entity)
    {
        return Room.create(entity.getNumberGuests());
    }

    @Override
    public RoomEntity assembleEntityFromDomain(Room domain)
    {
        return new RoomEntity(1L, domain.getNumberGuests());
    }

    @Override
    public List<Room> assembleDomainsFromEntities(List<RoomEntity> entities)
    {
        return entities.stream().map(getRoomAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public List<RoomEntity> assembleEntitiesFromDomains(List<Room> domains)
    {
        return domains.stream().map(getRoomAssembler()::assembleEntityFromDomain).toList();
    }
}