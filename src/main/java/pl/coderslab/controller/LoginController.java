package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.RememberMeTokenManager;
import pl.coderslab.directory.DirectoryDao;
import pl.coderslab.dto.NameInfoDTO;
import pl.coderslab.note.NoteDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;
import pl.coderslab.user.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    private final UserDao userDao;
    private final DirectoryDao directoryDao;
    private final NoteDao noteDao;
    private final UserService userService;
    private final HttpSession httpSession;

    private final RememberMeTokenManager rememberMeTokenManager;

    public LoginController(UserDao userDao, DirectoryDao directoryDao, NoteDao noteDao, UserService userService, HttpSession httpSession, RememberMeTokenManager rememberMeTokenManager) {
        this.directoryDao = directoryDao;
        this.userDao = userDao;
        this.noteDao = noteDao;
        this.userService = userService;
        this.httpSession = httpSession;
        this.rememberMeTokenManager = rememberMeTokenManager;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession session, NameInfoDTO nameInfoDTO, @RequestParam(value = "rememberMe",
                        required = false) boolean rememberMe, HttpServletResponse response) {
        if (userService.login(username, password)) {
            if (rememberMe) {
                Cookie cookie = new Cookie("rememberMeToken", rememberMeTokenManager.generateUniqueToken()); // Generate a unique token
                cookie.setMaxAge(7 * 24 * 60 * 60); // Set the cookie expiration time (7 days in this example)
                cookie.setPath("/"); // Set the cookie path to the root so it is accessible across the entire application
                response.addCookie(cookie); // Add the cookie to the response
            }
            String userType = userDao.findByUsername(username).getUserType();
            User loggedInUser = userService.findByUsername(username);
            session.setAttribute("loggedInUser", loggedInUser);
            model.addAttribute("username", username);
            model.addAttribute("usertype", userType);
            return "mainPage";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @RequestMapping("/guest")
    public String login(Model model, HttpSession session) {
        String username = "Guest";
        String userType = userDao.findByUsername(username).getUserType();
        User loggedInUser = userService.findByUsername(username);
        session.setAttribute("loggedInUser", loggedInUser);
        model.addAttribute("username", username);
        model.addAttribute("usertype", userType);
        return "mainPage";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
    @GetMapping("/mainPage")
    public String mainPage(HttpSession session, @CookieValue(value = "rememberMeToken", required = false) String rememberMeToken) {
        // Check if the session already exists (user has logged in previously)
        if (session.getAttribute("loggedInUser") != null) {
            // User is already logged in, load the main page directly
            return "mainPage"; // Assuming the template name is "mainPage.html"
        } else if (rememberMeToken != null) {
            // Validate the rememberMeToken (e.g., check it against the database)
            if (rememberMeTokenManager.isValidToken(rememberMeToken)) {
                // Create a new session and set the session attribute for the user
                session.setAttribute("loggedInUser", rememberMeTokenManager.getUsernameFromToken(rememberMeToken));
                return "mainPage"; // Load the main page directly
            }
        }

        // User needs to log in
        return "redirect:/login"; // Redirect to the login page
    }
}