package com.ceiba.adapter.repository.jdbc;

import com.ceiba.adapter.entity.DestinationEntity;
import java.util.List;

public interface DestinationDAO
{
    List<DestinationEntity> findAll();
    DestinationEntity findById();
    void save(DestinationEntity destination);
    void update(DestinationEntity destination);
    void delete(Long id);
}