package com.ceiba.reservation.service;

import com.ceiba.reservation.model.dto.ReservationSummaryDTO;
import com.ceiba.reservation.model.entity.Reservation;
import com.ceiba.reservation.port.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import static com.ceiba.reservation.model.assembler.implementation.ReservationAssemblerDomainImplementation.getReservationAssembler;

@Service
public class ServiceSaveReservation
{
    private final ServiceCalculatePrice serviceCalculatePrice;

    private final ReservationRepository reservationRepository;

    public ServiceSaveReservation(ServiceCalculatePrice serviceCalculatePrice, ReservationRepository reservationRepository)
    {
        this.serviceCalculatePrice = serviceCalculatePrice;
        this.reservationRepository = reservationRepository;
    }

    public ReservationSummaryDTO implement(Reservation reservation)
    {
        var dollarPrice = this.serviceCalculatePrice.calculatePrice(reservation.getDestination().getHotel().getNumberStars(), reservation.getDestination().getHotel().getRooms(), reservation.getCheckIn(), reservation.getCheckOut());
        var pesosPrice = this.serviceCalculatePrice.calculateCurrency(dollarPrice);

        var id = this.reservationRepository.save(reservation, dollarPrice);

        return getReservationAssembler().assembleDTOFromDomain(reservation, dollarPrice, pesosPrice, id);
    }
}