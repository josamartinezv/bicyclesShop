package com.adsi.bike.service;

import com.adsi.bike.domain.Bike;
import com.adsi.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class IBikeServiceImp implements IBikeService {

    //all business logic

    @Autowired
    BikeRepository bikeRepository;



    @Override
    public Iterable<Bike> read() {
        return bikeRepository.findAll();
    }

    @Override
    public Bike update(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public void delete(Integer id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public ResponseEntity create(Bike bike) {

        if(bikeRepository.findBySerial(bike.getSerial()).isPresent()){
            return new ResponseEntity("El serial ya existe", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(bikeRepository.save(bike), HttpStatus.OK);
        }
    }

    @Override
    public Optional<Bike> getById(@PathVariable Integer id) {
        return bikeRepository.findById(id);
    }

    @Override
    public ResponseEntity search(String serial, String model) {
        if (serial != null && model != null){
            return new ResponseEntity(bikeRepository.findBySerialContainsAndModelContains(serial, model), HttpStatus.OK);
        }else {
            if (serial != null) {
                return new ResponseEntity(bikeRepository.findBySerialContains(serial), HttpStatus.OK);
            } else if (model != null) {
                return new ResponseEntity(bikeRepository.findByModelContains(model), HttpStatus.OK);
            } else {
                return new ResponseEntity("No hay datos suficientes para la consulta", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
