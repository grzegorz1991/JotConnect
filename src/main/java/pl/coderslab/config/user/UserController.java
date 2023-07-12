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
			userService.addUser(user);
		} else {
			//userService.updateEmployee(user);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView model) {
		//userService.login(user);
		model.setViewName("filter");
		return model;
	}
}
