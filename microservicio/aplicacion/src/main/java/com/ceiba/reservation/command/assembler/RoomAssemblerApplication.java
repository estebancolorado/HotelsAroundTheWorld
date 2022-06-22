package com.ceiba.reservation.command.assembler;

import com.ceiba.reservation.command.RoomCommand;
import com.ceiba.reservation.model.entity.Room;
import java.util.List;

public interface RoomAssemblerApplication extends AssemblerApplication<Room, RoomCommand>
{
    List<Room> assembleDomainsFromDTOs(List<RoomCommand> dtos);
    List<RoomCommand> assembleDTOsFromDomains(List<Room> domains);
}