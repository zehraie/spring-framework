package com.cydeo.repository;

import com.cydeo.entityModel.Car;
import org.springframework.data.jpa.repository.JpaRepository;

// every Repository need public interface Repositorry<T,ID>{}
public interface CarRepository  extends JpaRepository<Car,Long> {
    //JPA has save(), findAll() and other all the methods it has.
    //custom methods
    //sql
}
