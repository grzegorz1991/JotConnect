package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.directory.DirectoryDao;
import pl.coderslab.dto.NameInfoDTO;
import pl.coderslab.note.NoteDao;
import pl.coderslab.user.UserDao;
import pl.coderslab.user.UserDaoImpl;
import pl.coderslab.user.UserService;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    private final UserDao userDao;
    private final DirectoryDao directoryDao;
    private final NoteDao noteDao;
    private final UserService userService;

    private final HttpSession httpSession;

    public LoginController(UserDao userDao, DirectoryDao directoryDao, NoteDao noteDao, UserService userService, HttpSession httpSession) {
        this.directoryDao = directoryDao;
        this.userDao = userDao;
        this.noteDao = noteDao;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session, NameInfoDTO nameInfoDTO) {
        if (userService.login(username, password)) {
            String userType =userDao.findByUsername(username).getUserType();

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
        String username = "Gest";
        String userType ="GUEST";
        model.addAttribute("usertype", userType);
        model.addAttribute("username", username);
        return "mainPage";
}}