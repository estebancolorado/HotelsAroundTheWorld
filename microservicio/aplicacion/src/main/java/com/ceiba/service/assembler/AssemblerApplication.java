package com.ceiba.service.assembler;

public interface AssemblerApplication<D, T>
{
    D assembleDomainFromDTO(T dto);

    T assembleDTOFromDomain(D domain);
}