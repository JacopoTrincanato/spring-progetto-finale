package org.lessons.java.spring_cars.controllers;

import org.lessons.java.spring_cars.models.Car;
import org.lessons.java.spring_cars.models.Optionals;
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
@RequestMapping("/optionals")
public class OptionalsController {

    @Autowired
    private OptionalsService optionalsService;

    // rotta index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("optionals", optionalsService.findOptionals());
        return "optionals/index";
    }

    // rotta show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("optional", optionalsService.getOptionalsById(id));
        return "optionals/show";
    }

    // rotta create
    @GetMapping("/create")
    public String create(Model model) {
        // creo il nuovo optional
        model.addAttribute("optional", new Optionals());

        return "optionals/create-or-edit";
    }

    // rotte store (crea effettivamente il nuovo optional)
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("optional") Optionals optionalForm, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "optionals/create-or-edit";
        }

        optionalsService.createOptionals(optionalForm);

        return "redirect:/optionals";
    }

    // rotta edit
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        // trovo l'optional per id
        model.addAttribute("optional", optionalsService.getOptionalsById(id));

        model.addAttribute("edit", true);

        return "optionals/create-or-edit";
    }

    // rotte update (aggiorna effettivamente l'optional)
    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("optional") Optionals optionalForm, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "optionals/create-or-edit";
        }

        optionalsService.updateOptionals(optionalForm);

        return "redirect:/optionals";
    }

    // rotta delete
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // cancella l'optional
        Optionals optionalsToDelete = optionalsService.getOptionalsById(id);

        for (Car linkedCar : optionalsToDelete.getCars()) {
            linkedCar.getOptionals().remove(optionalsToDelete);
        }

        optionalsService.deleteOptionals(optionalsToDelete);

        return "redirect:/optionals";
    }
}
