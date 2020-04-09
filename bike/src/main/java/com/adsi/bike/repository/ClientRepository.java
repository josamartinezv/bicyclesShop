package com.adsi.bike.repository;

import com.adsi.bike.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByDocumentNumber(String documentNumber);

    Iterable<Client> findByNameContains(String name);

    Iterable<Client> findByEmailContains(String email);

    Iterable<Client> findByDocumentNumberContains(String documentNumber);
}
