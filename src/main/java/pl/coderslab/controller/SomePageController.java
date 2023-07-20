package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.directory.Directory;
import pl.coderslab.directory.DirectoryService;
import pl.coderslab.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SomePageController {

    private final DirectoryService directoryService;

    public SomePageController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @RequestMapping("/createNote")
    public String redirect() {
        System.out.println("Redirecting to main page");
        return "createNote";
    }

    @GetMapping("/createNote")
    public String showCreateNoteForm(Model model, HttpSession session) {
        // Retrieve the logged-in user from the session (You may have this logic in place already)
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Get the directories for the current user
        List<Directory> userDirectories = directoryService.getDirectoriesByUserId(loggedInUser.getId());

        // Add the directories to the model
        model.addAttribute("directories", userDirectories);

        return "createNote"; // Replace "createNoteForm" with the actual JSP file name
    }

}
