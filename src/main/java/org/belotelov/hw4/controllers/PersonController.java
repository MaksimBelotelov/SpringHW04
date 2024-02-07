package org.belotelov.hw4.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.belotelov.hw4.model.Person;
import org.belotelov.hw4.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log
@AllArgsConstructor
@RequestMapping("/")
public class PersonController {
    private final PersonService personService;

    @GetMapping()
    public String showAllPersons(Model model) {
        List<Person> persons = personService.findAllPersons();
        model.addAttribute("persons", persons);
        log.info("Received reqiest to show all persons");
        return "index";
    }

    @GetMapping("/new")
    public String showNewPersonForm(Model model) {
        model.addAttribute("person", new Person());
        log.info("Received request to show form for adding new person");
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("Received incorrect data in form");
            return "new";
        }

        personService.addPerson(person);
        log.info("Added new person " + person.getName());
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        Person person = personService.getOne(id);
        model.addAttribute("person", person);
        log.info("Received request to show form for editing person");
        return "update";
    }

    @PostMapping("/update")
    public String updatePerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("Received incorrect data in form");
            return "update";
        }
        personService.updatePerson(person);
        log.info("Updated person " + person.getName());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.deletePersonById(id);
        log.info("Deleted person with id=" + id);
        return "redirect:/";
    }
}
