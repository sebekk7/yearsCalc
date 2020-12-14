package com.example.HowOldAreYou2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class HowOldController {


    @GetMapping("/form")
    public String showOrderForm(final ModelMap modelMap) {
        modelMap.addAttribute("howold", new Person());
        return "form";
    }

    @PostMapping("/form")
    public String handleNewOrder(@ModelAttribute("howold") final Person person, Model model) {

        int localDate = LocalDate.now().getYear();
        String years = String.valueOf(localDate - person.getYearOfBirth());
        String name = person.getName();


        model.addAttribute("yearsCalc", years);
        model.addAttribute("name", name);


        return "yearspage";
    }


}
