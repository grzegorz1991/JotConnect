package pl.coderslab.config.user;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			user.setPassword(user.getPassword());
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

//	public boolean login(String username, String password) {
//		// Retrieve the user from the database based on the provided username
//		User user = userDao.getUserByUsername(username);
//
//		if (user != null) {
//			// Check if the entered password matches the stored hashed password
//			if (user.checkPassword(password)) {
//				// Password is correct, allow login
//				return true;
//			}
//		}
//
//		// Password is incorrect or user not found
//		return false;
//	}

}
