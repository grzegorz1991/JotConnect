package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {


    @RequestMapping("/construction")

    public String construction() {
        return "construction";
    }

    @RequestMapping("/termsAndConditions")

    public String termsAndConditions() {
        return "termsAndConditions";
    }

}

