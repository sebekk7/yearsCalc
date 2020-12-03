package com.example.HowOldAreYou2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HowOldController {

    HowOldRepository howOldRepository = new HowOldRepository();

    @GetMapping("/form")
    public String showOrderForm(final ModelMap modelMap){
        modelMap.addAttribute("howold", new HowOld());
        return "form";
    }

    @PostMapping("/form")
    public String handleNewOrder(@ModelAttribute("howold") final HowOld howOld){
        return "yearspage";
    }


}
