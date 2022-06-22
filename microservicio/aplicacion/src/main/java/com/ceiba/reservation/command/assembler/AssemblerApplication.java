package com.ceiba.reservation.command.assembler;

public interface AssemblerApplication<D, T>
{
    D assembleDomainFromCommand(T dto);

    T assembleCommandFromDomain(D domain);
}