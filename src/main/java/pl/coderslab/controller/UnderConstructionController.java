package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UnderConstructionController {


    @RequestMapping("/construction")

    public String construction() {
        return "construction";
    }



}

