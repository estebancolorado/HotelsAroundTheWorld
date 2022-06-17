package com.ceiba.adapter.assembler;

public interface AssemblerInfrastructure<D, E>
{
    D assembleDomainFromEntity(E entity);

    E assembleEntityFromDomain(D domain);
}