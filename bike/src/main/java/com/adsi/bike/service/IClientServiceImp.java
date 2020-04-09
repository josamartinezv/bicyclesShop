package com.adsi.bike.service;

import com.adsi.bike.domain.Client;
import com.adsi.bike.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class IClientServiceImp implements IClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Iterable<Client> read(){ return clientRepository.findAll(); }

    @Override
    public Client update(Client client){ return clientRepository.save(client); }

    @Override
    public void delete (Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ResponseEntity create(Client client){

        if(clientRepository.findByDocumentNumber(client.getDocumentNumber()).isPresent()){
            return new ResponseEntity("El numero de documento ingresado ya existe", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(clientRepository.save(client), HttpStatus.OK);
        }

    }

    @Override
    public Optional<Client> getById(@PathVariable Integer id){
        return clientRepository.findById(id);
    }

    @Override
    public ResponseEntity search(String name, String email, String documentNumber) {
        if (name != null){
            return new ResponseEntity(clientRepository.findByNameContains(name), HttpStatus.OK);
        }else if (email != null){
            return  new ResponseEntity(clientRepository.findByEmailContains(email), HttpStatus.OK);
        }else if (documentNumber != null){
            return new ResponseEntity(clientRepository.findByDocumentNumberContains(documentNumber),HttpStatus.OK);
        }else {
            return new ResponseEntity("No hay datos suficientes para la consulta", HttpStatus.BAD_REQUEST);
        }

    }
}
