package com.ceiba.service;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepositoryCommand;
import org.springframework.stereotype.Service;
import static com.ceiba.assembler.implementation.ReservationAssemblerDomainImplementation.getReservationAssembler;

@Service
public class ServiceSaveReservation
{
    private final ServiceCalculatePrice serviceCalculatePrice;

    private final ReservationRepositoryCommand reservationRepositoryCommand;

    public ServiceSaveReservation(ServiceCalculatePrice serviceCalculatePrice, ReservationRepositoryCommand reservationRepositoryCommand)
    {
        this.serviceCalculatePrice = serviceCalculatePrice;
        this.reservationRepositoryCommand = reservationRepositoryCommand;
    }

    public ReservationSummaryDTO implement(Reservation reservation)
    {
        var dollarPrice = this.serviceCalculatePrice.calculatePrice(reservation.getDestination().getHotel().getNumberStars(), reservation.getDestination().getHotel().getRooms(), reservation.getCheckIn(), reservation.getCheckOut());
        var pesosPrice = this.serviceCalculatePrice.calculateCurrency(dollarPrice);

        var id = this.reservationRepositoryCommand.save(reservation, dollarPrice);

        return getReservationAssembler().assembleDTOFromDomain(reservation, dollarPrice, pesosPrice, id);
    }
}