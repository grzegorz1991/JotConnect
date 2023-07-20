package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.directory.Directory;
import pl.coderslab.directory.DirectoryDao;
import pl.coderslab.note.Note;
import pl.coderslab.note.NoteDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;

@Controller
public class RegisterUserConrtoller {

    private final UserDao userDao;
    private final DirectoryDao directoryDao;
    private final NoteDao noteDao;
    public RegisterUserConrtoller(UserDao userDao, DirectoryDao directoryDao, NoteDao noteDao){
        this.directoryDao = directoryDao;
        this.userDao = userDao;
        this.noteDao = noteDao;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password){

        //Creating new user
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(false);
        //Create root directories
        Directory directory = new Directory();
        directory.setAuthor(user);
        directory.setName(user.getUsername() + " Root directory");
        //Create root note
        Note note = new Note();
        note.setTitle("Welcome "+ user.getUsername());
        note.setContent("This is your first note!");
        note.setDirectory(directory);
        note.setAuthor(user);
        //
        userDao.saveUser(user);
        directoryDao.save(directory);
        noteDao.save(note);

        return "redirect:/login";
    }

}
