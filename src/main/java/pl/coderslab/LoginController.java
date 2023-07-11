package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {


    @RequestMapping("/")

    public String redirect() {
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Implement your login logic here
        // Validate the username and password, perform authentication, etc.
        // You can use a service or repository to handle the login process

        if (username.equals("admin") && password.equals("password")) {
            // Successful login, redirect to the home page or desired destination
            return "redirect:/home";
        } else {
            // Invalid credentials, show an error message or redirect back to the login page
            return "redirect:/login?error";
        }
    }
}

