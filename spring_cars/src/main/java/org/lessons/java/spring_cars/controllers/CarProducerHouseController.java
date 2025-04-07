package org.lessons.java.spring_cars.controllers;

import org.lessons.java.spring_cars.models.CarProducerHouse;
import org.lessons.java.spring_cars.services.CarProducerHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/house-producer")
public class CarProducerHouseController {

    @Autowired
    private CarProducerHouseService carProducerHouseService;

    // creo la store
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("carProducerHouse") CarProducerHouse carProducerHouseForm,
            BindingResult bindingResult, Model model) {
        // verifico che il processo di validazione sia avvenuto correttamente
        if (bindingResult.hasErrors()) {

            return "carProducerHouses/create-or-edit";
        }

        // salvo il dato
        carProducerHouseService.createCarProducerHouse(carProducerHouseForm);

        return "redirect:/carProducerHouses";
    }

    // creo la rotta edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("carProducerHouse", carProducerHouseService.getCarProducerHouseById(id));
        model.addAttribute("edit", true);
        return "carProducerHouses/create-or-edit";
    }

    // creo update per modificare gli elementi della card
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("carProducerHouses") CarProducerHouse carProducerHouseForm,
            BindingResult bindingResult, Model model) {

        // verifico che il processo di validazione sia avvenuto correttamente
        if (bindingResult.hasErrors()) {
            return "cars/create-or-edit";
        }

        // aggiorno il dato
        carProducerHouseService.updateCarProducerHouse(carProducerHouseForm);

        return "redirect:/carProducerHouses/" + carProducerHouseForm.getId();
    }

    // creo la rotta delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        // prendo tutti gli optional della macchina
        CarProducerHouse carProducerHouse = carProducerHouseService.getCarProducerHouseById(id);

        // cancello la macchina
        carProducerHouseService.deleteCarProducerHouse(carProducerHouse);

        return "redirect:/cars";
    }

}
