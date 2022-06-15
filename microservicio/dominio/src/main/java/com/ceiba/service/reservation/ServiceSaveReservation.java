package com.ceiba.service.reservation;

import com.ceiba.dto.ReservationSummaryDTO;
import com.ceiba.model.Reservation;
import com.ceiba.port.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.ceiba.service.assembler.implementation.ReservationAssemblerDomainImplementation.getReservationAssembler;

@Service
public class ServiceSaveReservation
{
    @Autowired
    ServiceCalculatePrice serviceCalculatePrice;
    @Autowired
    ReservationRepository reservationRepository;

    public ReservationSummaryDTO implement(Reservation reservation)
    {
        var dollarPrice = this.serviceCalculatePrice.calculatePrice(reservation.getDestination().getHotel().getNumberStars(), reservation.getDestination().getHotel().getRooms(), reservation.getCheckIn(), reservation.getCheckOut());
        var pesosPrice = this.serviceCalculatePrice.calculateCurrency(dollarPrice);

        var id = this.reservationRepository.save(reservation, dollarPrice);

        return getReservationAssembler().assembleDTOFromDomain(reservation, dollarPrice, pesosPrice, id);
    }
}