package org.lessons.java.spring_cars.services;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_cars.models.Car;
import org.lessons.java.spring_cars.models.CarProducerHouse;
import org.lessons.java.spring_cars.repositories.CarProducerHouseRepository;
import org.lessons.java.spring_cars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarProducerHouseRepository carProducerHouseRepository;

    // metodo per trovare tutte le macchine
    public List<Car> findCars() {
        return carRepository.findAll();
    }

    // metodo per trovare la macchina per id
    public Optional<Car> findCarById(Integer id) {
        return carRepository.findById(id);
    }

    // metodo per ottenere la macchina per id
    public Car getCarById(Integer id) {
        Optional<Car> carAttempt = carRepository.findById(id);
        return carAttempt.get();
    }

    // metodo per la creazione della macchina
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    // metodo per l'aggiornamento dei dati della macchina
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    // metodo per cancellare la macchina
    public void deleteCar(Car car) {

        CarProducerHouse producerHouseToDelete = car.getProducerHouse();

        // cancello la casa di produzione
        carProducerHouseRepository.delete(producerHouseToDelete);

        // cancello la macchina
        carRepository.delete(car);
    }

    // metodo per cancellare la macchina per id
    public void deleteCarById(Integer id) {

        Car car = getCarById(id);

        CarProducerHouse producerHouseToDelete = car.getProducerHouse();

        // cancello la casa di produzione
        carProducerHouseRepository.delete(producerHouseToDelete);

        // cancello la macchina
        carRepository.delete(car);
    }
}
