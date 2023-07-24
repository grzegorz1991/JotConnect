package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.directory.Directory;
import pl.coderslab.directory.DirectoryService;
import pl.coderslab.note.Note;
import pl.coderslab.note.NoteDTO;
import pl.coderslab.note.NoteService;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SomePageController {

    private final DirectoryService directoryService;

    private final NoteService noteService;

    private final UserService userService;

    public SomePageController(DirectoryService directoryService, NoteService noteService, UserService userService) {
        this.directoryService = directoryService;
        this.noteService = noteService;
        this.userService = userService;
    }

    @RequestMapping("/createNote")
    public String redirect() {
        System.out.println("Redirecting to main page");
        return "createNote";
    }

    @GetMapping("/createNote")
    public String showCreateNoteForm(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        List<Directory> userDirectories = directoryService.getDirectoriesByUserId(loggedInUser.getId());
        model.addAttribute("directories", userDirectories);
        return "createNote";
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello(HttpSession session) {
        // Check if the user is logged in
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            // User is logged in, return their username
            return "Hello, " + loggedInUser.getUsername() + "!";
        } else {
            // User is not logged in
            return "Hello, guest!";
        }
    }

    @GetMapping("/user/debug")
    @ResponseBody
    public List<Note> getUserNotes(Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (user != null) {
            List<Note> userNotes = noteService.getUserNotes(user);
            System.out.println("User Notes: " + userNotes); // Add this debug log
            return userNotes;
        } else {
            return new ArrayList<>();
        }
    }
//@GetMapping("/user/notes")
//@ResponseBody
//public List<Note> getUserNotes(HttpServletRequest request) {
//    Principal principal = request.getUserPrincipal();
//    if (principal != null) {
//        String username = principal.getName();
//        User user = userService.findByUsername(username);
//        if (user != null) {
//            List<Note> userNotes = noteService.getUserNotes(user);
//            System.out.println("User Notes: " + userNotes);
//            return userNotes;
//        } else {
//            return new ArrayList<>();
//        }
//    } else {
//        return new ArrayList<>();
//    }
//}

    //    @GetMapping("/user/notes")
//    @ResponseBody
//    public List<Note> getUserNotes(HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//        if (loggedInUser != null) {
//            List<Note> userNotes = noteService.getUserNotes(loggedInUser);
//            System.out.println("User Notes: " + userNotes);
//            return userNotes;
//        } else {
//            return new ArrayList<>();
//        }
//    }
@GetMapping("/user/printNotes")
@ResponseBody
public void getUserTestNotes(Principal principal) {
    String username = principal.getName();
    User user = userService.findByUsername(username);
    if (user != null) {
        List<Note> userNotes = noteService.getUserNotes(user);
        System.out.println("User Notes:");
        for (Note note : userNotes) {
            System.out.println(note.toString());
        }
    } else {
        System.out.println("User not found.");
    }
}
    @GetMapping("/user/notes")
    @ResponseBody
    public ResponseEntity<List<Note>> getUserPincipalNotes(Principal principal) {
        if (principal == null) {
            System.out.println("User is not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<Note> userNotes = noteService.getUserNotes(user);
        return ResponseEntity.ok(userNotes);
    }
    @GetMapping("/displayUserNotes")
    public void displayUserNotesInTerminal(HttpSession session) {
        // Check if the user is logged in
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            System.out.println("User not logged in.");
            return;
        }

        // Fetch the user's notes from the service layer
        List<Note> userNotes = noteService.getUserNotes(loggedInUser);

        // Print the notes to the console
        for (Note note : userNotes) {
            System.out.println("Title: " + note.getTitle());
            System.out.println("Content: " + note.getContent());
            System.out.println("Created Date: " + note.getCreatedDate());
            System.out.println("----------------------------------");
        }
    }
    @GetMapping("/notes")
    @ResponseBody
    public ResponseEntity<List<NoteDTO>> getNotes() {
        try {
            List<Note> notes = noteService.getAllNotes();
            List<NoteDTO> noteDTOs = new ArrayList<>();

            // Convert Note objects to NoteDTOs containing only title and author (username)
            for (Note note : notes) {
                NoteDTO noteDTO = new NoteDTO();
                noteDTO.setTitle(note.getTitle());
                noteDTO.setAuthor(note.getAuthor().getUsername());
                noteDTOs.add(noteDTO);
                System.out.println(note.getTitle());
            }

            return ResponseEntity.ok(noteDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

