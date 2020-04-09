package com.adsi.bike.web.rest;

import com.adsi.bike.domain.Bike;
import com.adsi.bike.service.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BikeResource {

    @Autowired
    IBikeService bikeService;

    // my api-rest create

    @PostMapping("/bike")
    public ResponseEntity create(@RequestBody Bike bike) {
        return bikeService.create(bike);
    }

    //api-rest read all bikes

    @GetMapping("/bike")
    public Iterable<Bike> read() {
        return bikeService.read();
    }

    //api-rest delete a bike
    @DeleteMapping("/bike/{id}")
    public void delete(@PathVariable Integer id) {
        bikeService.delete(id);
    }
    //api-rest update a bike

    @PutMapping("/bike")
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    @GetMapping("/bike/{id}")
    public Optional<Bike> getById(@PathVariable Integer id){
        return bikeService.getById(id);
    }

    @GetMapping("/bike/search")
    public ResponseEntity search(@RequestParam(value = "serial", required = false)String serial,
                                 @RequestParam(value = "model", required = false) String model){
        return bikeService.search(serial, model);
    }
}