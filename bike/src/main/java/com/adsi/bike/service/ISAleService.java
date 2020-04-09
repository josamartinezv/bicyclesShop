package com.adsi.bike.service;

import com.adsi.bike.domain.Sale;

import java.util.Optional;

public interface ISAleService {

    // get - obtener - read
    public Iterable<Sale> read();

    // put - actualizar - update
    public Sale update(Sale sale);

    // Delete - borrar - delete
    public void delete(Integer id);

    // post - guardar - create
    public Sale create(Sale sale);

    public Optional<Sale> getById(Integer id);
}
