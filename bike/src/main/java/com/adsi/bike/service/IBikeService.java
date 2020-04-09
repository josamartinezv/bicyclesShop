package com.adsi.bike.service;

import com.adsi.bike.domain.Bike;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IBikeService {

    // get - obtener - read
    public Iterable<Bike> read();

    // put - actualizar - update
    public Bike update(Bike bike);

    // Delete - borrar - delete
    public void delete(Integer id);

    // post - guardar - create
    public ResponseEntity create(Bike bike);

    public Optional<Bike> getById(Integer id);

    public ResponseEntity search (String seria, String model);


}
