package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarDearler implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;

    private void saveCar(Car car){
        Car savedCar = carRepository.save(car);
        System.out.println("Car saved:"+car);
    }

    private Car fetchCar(long id){
        Car car = null;
        Optional<Car> carInDb = carRepository.findById(id);

        if(carInDb.isPresent())
            car = carInDb.get();

        return car;

    }

    @Override
    public void run(String... args) throws Exception {
        Car car = new Car("BMW", "X5");
        saveCar(car);
        Car c = fetchCar(1);
        System.out.println(c);
    }
}
