package org.belotelov.hw4.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.belotelov.hw4.model.Person;
import org.belotelov.hw4.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class PersonController {
    private final PersonService personService;

    @GetMapping()
    public String showAllPersons(Model model) {
        List<Person> persons = personService.findAllPersons();
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping("/new")
    public String showNewPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        personService.addPerson(person);
        return "redirect:/";
    }
}
