package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TermsAndConditionsController {

    @GetMapping("/termsAndConditions")
    public String termsAndConditions(){
        return "termsAndConditions";
    }
}
