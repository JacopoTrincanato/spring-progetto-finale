package org.lessons.java.spring_cars.controllers;

import java.util.List;

import org.lessons.java.spring_cars.models.Car;
import org.lessons.java.spring_cars.services.CarService;
import org.lessons.java.spring_cars.services.OptionalsService;
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
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private OptionalsService optionalsService;

    // creo la rotta index
    @GetMapping
    public String index(Model model) {
        // creo la lista di macchine
        List<Car> cars = carService.findCars();

        model.addAttribute("cars", cars);

        return "cars/index";
    }

    // creo la rotta show
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("id", id);

        Car car = carService.getCarById(id);

        model.addAttribute("car", car);

        return "cars/show";
    }

    // creo la rotta create
    @GetMapping("/create")
    public String create(Model model) {
        // creo la macchina
        model.addAttribute("car", new Car());

        // prendo tutti gli optional
        model.addAttribute("optionals", optionalsService.findOptionals());

        return "cars/create-or-edit";
    }

    // creo la store
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("car") Car carForm, BindingResult bindingResult, Model model) {
        // verifico che il processo di validazione sia avvenuto correttamente
        if (bindingResult.hasErrors()) {
            // prendo tutti gli optional
            model.addAttribute("optionals", optionalsService.findOptionals());

            return "cars/create-or-edit";
        }

        // salvo il dato
        carService.createCar(carForm);

        return "redirect:/cars";
    }

    // creo la rotta edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        // prendo tutti gli optional
        model.addAttribute("optionals", optionalsService.findOptionals());
        model.addAttribute("car", carService.getCarById(id));
        model.addAttribute("edit", true);
        return "cars/create-or-edit";
    }

    // creo update per modificare gli elementi della card
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("car") Car carForm, BindingResult bindingResult, Model model) {

        // verifico che il processo di validazione sia avvenuto correttamente
        if (bindingResult.hasErrors()) {
            // prendo tutti gli optional
            model.addAttribute("optionals", optionalsService.findOptionals());
            return "cars/create-or-edit";
        }

        // aggiorno il dato
        carService.updateCar(carForm);

        return "redirect:/cars/" + carForm.getId();
    }

    // creo la rotta delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        // prendo tutti gli optional della macchina
        Car car = carService.getCarById(id);

        // cancello la macchina
        carService.deleteCar(car);

        return "redirect:/cars";
    }

}
