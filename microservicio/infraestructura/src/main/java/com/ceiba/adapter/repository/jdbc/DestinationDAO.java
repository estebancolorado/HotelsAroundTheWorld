package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.DestinationEntity;
import java.util.List;

public interface DestinationDAO
{
    List<DestinationEntity> findAll();
    DestinationEntity findById(Long id);
    Long save(DestinationEntity destination, Long hotelId);
    Long update(DestinationEntity destination);
    Long delete(Long id);
}