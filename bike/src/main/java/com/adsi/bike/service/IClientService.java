package com.adsi.bike.service;

import com.adsi.bike.domain.Client;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IClientService {

    // get - obtener - read
    public Iterable<Client> read();

    // put - actualizar - update
    public Client update(Client client);

    // Delete - borrar - delete
    public void delete (Integer id);

    // post - guardar - create
    public ResponseEntity create(Client client);

    public Optional<Client> getById(Integer id);

    public ResponseEntity search (String name, String email, String documentNumber);
}
