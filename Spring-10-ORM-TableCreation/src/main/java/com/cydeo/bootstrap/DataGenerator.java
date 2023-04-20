package com.cydeo.bootstrap;

import com.cydeo.entityModel.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("BMW", "tmm1");
        Car car2 = new Car("Honda", "tmm2");
        Car car3 = new Car("Mercedes", "tmm3");
        //save these objects to db

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);



    }
}
