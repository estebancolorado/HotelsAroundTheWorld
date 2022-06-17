package com.ceiba.assembler;

public interface AssemblerApplication<D, T>
{
    D assembleDomainFromDTO(T dto);

    T assembleDTOFromDomain(D domain);
}