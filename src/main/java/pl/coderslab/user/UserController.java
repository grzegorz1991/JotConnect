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
            System.out.println("usernameExists");
            modelAndView.addObject("usernameError", "Username already exists");
            modelAndView.setViewName("register");
            return modelAndView; // Return immediately after setting the error message and view name
        }

        if (userService.isEmailExists(user.getEmail())) {
            System.out.println("Email exists");
            modelAndView.addObject("emailError", "Email already exists");
            modelAndView.setViewName("register");
            return modelAndView; // Return immediately after setting the error message and view name
        }

        // Add the user if username and email are unique
        userService.addUser(user);
        modelAndView.setViewName("redirect:/login");
        return modelAndView; // Return after setting the view name for redirect
    }

        @RequestMapping(value = "/login1", method = RequestMethod.POST)
        public ModelAndView login (ModelAndView model){
            //userService.login(user);
            model.setViewName("filter");
            return model;
        }
        @GetMapping("/login")
        public String showLoginPage () {
            return "login";
        }


        @PostMapping("/login")
        public String login (@RequestParam("username") String username, @RequestParam("password") String password){
            System.out.println("Login attempt for" + username);
            // Perform the login validation
            if (userService.login(username, password)) {
                System.out.println("gówno");
                // Redirect to the home view
                return "redirect:/home";
            } else {
                // Login failed, show an error message or redirect back to the login page
                System.out.println("Login failed");
                return "redirect:/login?error";
            }
        }
        @RequestMapping("/home")
        public String home () {
            return "home";
        }


    }
