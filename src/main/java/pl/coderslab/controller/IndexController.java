package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {


    @RequestMapping("/")
    public String redirect() {
        System.out.println("Redirecting to main page");
        return "redirect:/login";
    }
    @RequestMapping("/test")
    public String test() {
        System.out.println("testing");
        return "redirect:/";
    }
}

