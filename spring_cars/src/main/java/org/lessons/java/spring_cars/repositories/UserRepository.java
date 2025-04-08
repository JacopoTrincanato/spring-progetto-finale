package org.lessons.java.spring_cars.repositories;

import java.util.Optional;

import org.lessons.java.spring_cars.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // metodo che implementa il recupero tramite username
    public Optional<User> findByUsername(String username);
}
