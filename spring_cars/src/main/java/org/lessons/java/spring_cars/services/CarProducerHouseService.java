package org.lessons.java.spring_cars.services;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_cars.models.CarProducerHouse;
import org.lessons.java.spring_cars.repositories.CarProducerHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarProducerHouseService {

    @Autowired
    private CarProducerHouseRepository carProducerHouseRepository;

    // metodo per trovare tutte le case produttrici
    public List<CarProducerHouse> findCarProducers() {
        return carProducerHouseRepository.findAll();
    }

    // metodo per ottenere la casa produttrice per id
    public CarProducerHouse getCarProducerHouseById(Integer id) {
        Optional<CarProducerHouse> carProducerHouseAttempt = carProducerHouseRepository.findById(id);
        return carProducerHouseAttempt.get();
    }

    // metodo per la creazione della casa produttrice
    public CarProducerHouse createCarProducerHouse(CarProducerHouse carProducerHouse) {
        return carProducerHouseRepository.save(carProducerHouse);
    }

    // metodo per l'aggiornamento dei dati della casa produttrice
    public CarProducerHouse updateCarProducerHouse(CarProducerHouse carProducerHouse) {
        return carProducerHouseRepository.save(carProducerHouse);
    }

    // metodo per cancellare la casa produttrice
    public void deleteCarProducerHouse(CarProducerHouse carProducerHouse) {
        // cancello la casa di produzione
        carProducerHouseRepository.delete(carProducerHouse);
    }

    // metodo per cancellare la casa produttrice per id
    public void deleteCarProducerHouseById(Integer id) {
        // cancello la casa di produzione
        carProducerHouseRepository.deleteById(id);
    }

}
