package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.note.Note;
import pl.coderslab.note.NoteService;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;
    // ...

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute Note note, HttpSession session) {
        // Set the author of the note to the current user (assuming you have stored the user in the session)
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        note.setAuthor(loggedInUser);

        // Save the note
        noteService.save(note);

        // Redirect to the main page or wherever you want to go after saving the note
        return "redirect:/mainPage";
    }

    // ...
}
