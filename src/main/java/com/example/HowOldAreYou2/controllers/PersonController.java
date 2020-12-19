package com.example.HowOldAreYou2.controllers;

import com.example.HowOldAreYou2.entities.Person;
import com.example.HowOldAreYou2.repositories.PersonRepo;
import com.example.HowOldAreYou2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("showRepo", personRepo.findAll());

        return "form";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Person person = personRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        personRepo.delete(person);
        model.addAttribute("users", personRepo.findAll());
        return "redirect:/form";
    }











    @PostMapping("/form")
    public String addUser(Person person, Model model) {
        person.setYears(LocalDate.now().getYear() - person.getYearOfBirth());
        personRepo.save(person);
        personList.add(person);
        return "redirect:/form";
    }



}
