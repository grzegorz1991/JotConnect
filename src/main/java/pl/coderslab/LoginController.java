package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {


    @RequestMapping("/")

    public String redirectToGoogle() {
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}

