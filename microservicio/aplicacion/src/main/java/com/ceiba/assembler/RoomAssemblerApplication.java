package com.ceiba.assembler;

import com.ceiba.dto.RoomDTO;
import com.ceiba.model.Room;
import java.util.List;

public interface RoomAssemblerApplication extends AssemblerApplication<Room, RoomDTO>
{
    List<Room> assembleDomainsFromDTOs(List<RoomDTO> dtos);
    List<RoomDTO> assembleDTOsFromDomains(List<Room> domains);
}