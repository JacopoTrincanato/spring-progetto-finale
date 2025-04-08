package org.lessons.java.spring_cars.controllers;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_cars.models.Car;
import org.lessons.java.spring_cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class RestCarController {

    @Autowired
    private CarService carService;

    // index
    @GetMapping
    public List<Car> index() {
        List<Car> cars = carService.findCars();
        return cars;
    }

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Car> show(@Valid @PathVariable Integer id) {

        Optional<Car> carAttempt = carService.findCarById(id);

        // controllo se carAttempt è vuoto
        if (carAttempt.isEmpty()) {

            // se non è presente, invio una 404
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        // altrimenti mostro la car
        return new ResponseEntity<Car>(carAttempt.get(), HttpStatus.OK);

    }

    // store
    @PostMapping
    public ResponseEntity<Car> store(@Valid @RequestBody Car car) {

        // creo la nuova car
        return new ResponseEntity<Car>(carService.createCar(car), HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@Valid @RequestBody Car car, @Valid @PathVariable Integer id) {

        // controllo se il campo della car è vuoto
        if (carService.findCarById(id).isEmpty()) {

            // se non è presente, invio una 404
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        // imposto l'id
        car.setId(id);

        // altrimenti mostro la car
        return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);

    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@Valid @RequestBody Car car, @Valid @PathVariable Integer id) {

        // controllo se il campo della car è vuoto
        if (carService.findCarById(id).isEmpty()) {

            // se non è presente, invio una 404
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        // altrimenti mostro che la car è stata cancellata correttamente
        return new ResponseEntity<Car>(HttpStatus.OK);

    }
}
