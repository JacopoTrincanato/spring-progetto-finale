package org.lessons.java.spring_cars.services;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring_cars.models.Optionals;
import org.lessons.java.spring_cars.repositories.OptionalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionalsService {

    @Autowired
    private OptionalsRepository optionalsRepository;

    // metodo per trovare tutti gli optionals
    public List<Optionals> findOptionals() {
        return optionalsRepository.findAll();
    }

    // metodo per ottenere l'optional per id
    public Optionals getOptionalsById(Integer id) {
        Optional<Optionals> optionalsAttempt = optionalsRepository.findById(id);
        return optionalsAttempt.get();
    }

    // metodo per la creazione dell'optional
    public Optionals createOptionals(Optionals optionals) {
        return optionalsRepository.save(optionals);
    }

    // metodo per l'aggiornamento dei dati dell'optional
    public Optionals updateOptionals(Optionals optionals) {
        return optionalsRepository.save(optionals);
    }

    // metodo per cancellare l'optional
    public void deleteOptionals(Optionals optionals) {
        // cancello la casa di produzione
        optionalsRepository.delete(optionals);
    }

    // metodo per cancellare l'optional per id
    public void deleteOptionalsById(Integer id) {
        // cancello la casa di produzione
        optionalsRepository.deleteById(id);
    }

}
