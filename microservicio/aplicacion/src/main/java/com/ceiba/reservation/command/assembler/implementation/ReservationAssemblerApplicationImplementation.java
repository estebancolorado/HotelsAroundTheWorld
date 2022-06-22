package com.ceiba.reservation.command.assembler.implementation;

import com.ceiba.reservation.command.ReservationCommand;
import com.ceiba.formatter.FormatDate;
import com.ceiba.reservation.model.entity.Reservation;
import com.ceiba.reservation.command.assembler.ReservationAssemblerApplication;
import static com.ceiba.reservation.command.assembler.implementation.DestinationAssemblerApplicationImplementation.getDestinationAssembler;

public final class ReservationAssemblerApplicationImplementation implements ReservationAssemblerApplication
{
    private static final ReservationAssemblerApplication INSTANCE = new ReservationAssemblerApplicationImplementation();

    private ReservationAssemblerApplicationImplementation()
    {

    }

    public static ReservationAssemblerApplication getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromCommand(ReservationCommand dto)
    {
        return Reservation.create(FormatDate.getDate(dto.getCheckIn()), FormatDate.getDate(dto.getCheckOut()), getDestinationAssembler().assembleDomainFromCommand(dto.getDestination()));
    }

    @Override
    public ReservationCommand assembleCommandFromDomain(Reservation domain)
    {
        return new ReservationCommand(FormatDate.getStringDate(domain.getCheckIn()), FormatDate.getStringDate(domain.getCheckOut()), getDestinationAssembler().assembleCommandFromDomain(domain.getDestination()));
    }
}