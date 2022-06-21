package com.ceiba.adapter.repository.implementation;

import com.ceiba.adapter.repository.jdbc.DestinationDAO;
import com.ceiba.adapter.repository.jdbc.HotelDAO;
import com.ceiba.adapter.repository.jdbc.ReservationDAO;
import com.ceiba.adapter.repository.jdbc.RoomDAO;
import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepository;
import com.ceiba.validator.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ceiba.adapter.assembler.implementation.ReservationAssemblerInfrastructureImplementation.getReservationAssembler;

@Repository
public class ReservationRepositoryImplementation implements ReservationRepository
{
    @Autowired
    HotelDAO hotelDAO;
    @Autowired
    RoomDAO roomDAO;
    @Autowired
    DestinationDAO destinationDAO;
    @Autowired
    ReservationDAO reservationDAO;

    @Override
    public List<ReservationSummaryDTO> getAll()
    {
        return this.reservationDAO.findAll().stream().map(getReservationAssembler()::assembleDTOFromEntity).toList();
    }

    @Override
    public ReservationSummaryDTO getById(Long id)
    {
        var entity = this.reservationDAO.findById(id);

        if(ValidateObject.isNull(entity))
        {
            return null;
        }

        return getReservationAssembler().assembleDTOFromEntity(entity);
    }

    @Override
    public Long save(Reservation reservation, double price)
    {
        var entity = getReservationAssembler().assembleEntityFromDomain(reservation);

        entity.setPrice(price);

        var hotelId = hotelDAO.save(entity.getDestination().getHotel());

        entity.getDestination().getHotel().getRooms().forEach(room -> roomDAO.save(room, hotelId));

        var destinationId = destinationDAO.save(entity.getDestination(), hotelId);

        return reservationDAO.save(entity, destinationId);
    }

    @Override
    public Long delete(Long id)
    {
        var reservation = reservationDAO.findById(id);

        reservationDAO.delete(reservation.getId());
        destinationDAO.delete(reservation.getDestination().getId());
        reservation.getDestination().getHotel().getRooms().forEach(room -> roomDAO.delete(room.getId()));
        hotelDAO.delete(reservation.getDestination().getHotel().getId());

        return id;
    }
}
