package com.example.HowOldAreYou2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

@Service
@Controller
public class HowOldController {

    @GetMapping("/form")
    public String showOrderForm(final ModelMap modelMap) {
        modelMap.addAttribute("howold", new Person());
        return "form";
    }


    @PostMapping("/form")
    public String handleNewOrder(@ModelAttribute("howold") final Person person, Model model) {

        int year = LocalDate.now().getYear() - person.getYearOfBirth();
        String name = person.getName();

        model.addAttribute("yearsCalc", year);
        model.addAttribute("name", name);

        return "yearspage";
    }


}
