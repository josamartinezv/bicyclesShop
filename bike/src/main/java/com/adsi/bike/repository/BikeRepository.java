package com.adsi.bike.repository;

import com.adsi.bike.domain.Bike;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BikeRepository extends CrudRepository<Bike, Integer> {

    Optional<Bike> findBySerial(String serial);

    Iterable<Bike> findBySerialContains(String serial);

    Iterable<Bike> findByModelContains(String model);

    Iterable<Bike> findBySerialContainsAndModelContains(String serial, String model);

}
