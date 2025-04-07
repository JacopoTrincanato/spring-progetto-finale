package org.lessons.java.spring_cars.repositories;

import org.lessons.java.spring_cars.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
