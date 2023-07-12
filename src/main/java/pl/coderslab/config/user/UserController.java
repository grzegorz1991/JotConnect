package pl.coderslab.config.user;

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
	public ModelAndView saveUser(@ModelAttribute User user) {
		if (user.getId() == 0) {
			// If user is new, encrypt the password before saving
			System.out.println(user.getPassword() + " saveUser.UserController getPassword");
			userService.addUser(user);
		} else {
			//userService.updateEmployee(user);
		}
		userService.addUser(user);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView model) {
		//userService.login(user);
		model.setViewName("filter");
		return model;
	}
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}


	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
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
	public String home() {
		return "home";
	}


}
