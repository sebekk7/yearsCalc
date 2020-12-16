package com.example.HowOldAreYou2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HowOldController {

    @GetMapping("/form")
    public String showOrderForm(final ModelMap modelMap) {
        modelMap.addAttribute("person", new Person());
        return "form";
    }

    private PersonRepo personRepo;

    @PostMapping("/form")
    public String handleNewOrder(@ModelAttribute("person") Person person, Model model) {

        String name = person.getName();
        int year = LocalDate.now().getYear() - person.getYearOfBirth();


        model.addAttribute("name", name);
        model.addAttribute("yearsCalc", year);

        personRepo.save(new Person(name, year));
        model.addAttribute("person", personRepo.findAll());
        return "form";
    }

}
