package com.example.HowOldAreYou2.controllers;

import com.example.HowOldAreYou2.entities.Person;
import com.example.HowOldAreYou2.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    private final PersonRepo personRepo;

    @Autowired
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    private final List<Person> personList = new ArrayList<>();

    @GetMapping("/form")
    public String showOrderForm(final Model model) {
        model.addAttribute("newPerson", new Person());
        model.addAttribute("personList", personList);
        return "form";
    }

    @PostMapping("/form")
    public String addUser(Person person, Model model) {

        person.setYears(LocalDate.now().getYear() - person.getYearOfBirth());

        personRepo.save(person);
        model.addAttribute("newPerson", personRepo.findAll());

        personList.add(person);
        return "redirect:/form";
    }


}
