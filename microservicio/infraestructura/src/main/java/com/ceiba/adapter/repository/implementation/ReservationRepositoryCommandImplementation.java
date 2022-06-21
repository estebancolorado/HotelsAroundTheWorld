package com.ceiba.adapter.repository.implementation;

import com.ceiba.adapter.repository.jdbc.DestinationDAO;
import com.ceiba.adapter.repository.jdbc.HotelDAO;
import com.ceiba.adapter.repository.jdbc.ReservationDAO;
import com.ceiba.adapter.repository.jdbc.RoomDAO;
import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepositoryCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.ceiba.adapter.assembler.implementation.ReservationAssemblerInfrastructureImplementation.getReservationAssembler;

@Repository
public class ReservationRepositoryCommandImplementation implements ReservationRepositoryCommand
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
