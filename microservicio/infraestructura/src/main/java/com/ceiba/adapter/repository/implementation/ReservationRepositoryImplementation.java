package com.ceiba.adapter.repository.implementation;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryImplementation implements ReservationRepository
{
    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        return null;
    }

    @Override
    public Long save(Reservation reservation, double price)
    {
        return null;
    }

    @Override
    public Long update(Reservation reservation, double price, Long id)
    {
        return null;
    }

    @Override
    public void delete(Long id)
    {

    }
}
