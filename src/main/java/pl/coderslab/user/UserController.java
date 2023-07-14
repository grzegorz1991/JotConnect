package pl.coderslab.user;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("UserController()");
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("register");
        return model;
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user, ModelAndView modelAndView) {
        if (userService.isUsernameExists(user.getUsername())) {
            modelAndView.addObject("usernameError", "Username already exists");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if (userService.isEmailExists(user.getEmail())) {
            modelAndView.addObject("emailError", "Email already exists");
            modelAndView.setViewName("register");
            return modelAndView;
        }
        userService.addUser(user);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (userService.login(username, password)) {
            return "redirect:/mainPage";
        } else {
            return "redirect:/login?error";
        }
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/termsAndConditions")

    public String termsAndConditions() {
        return "termsAndConditions";
    }
}
