package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.directory.Directory;
import pl.coderslab.directory.DirectoryDao;
import pl.coderslab.directory.DirectoryDaoImpl;
import pl.coderslab.note.Note;
import pl.coderslab.note.NoteDao;

@Controller
public class UserController {

    private final UserDao userDao;
    private final DirectoryDao directoryDao;
    private final NoteDao noteDao;
    public UserController(UserDao userDao, DirectoryDao directoryDao, NoteDao noteDao){
        this.directoryDao = directoryDao;
        this.userDao = userDao;
        this.noteDao = noteDao;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/test")
    public String test(){
        //User database test
        User user = new User();
        user.setUsername("Tester Name");
        user.setEmail("Test@test.com");
        user.setAdmin(false);
        userDao.saveUser(user);

        //Directory database test
        Directory directory = new Directory();
        directory.setAuthor(user);
        directory.setName("rootDirectory");
        directoryDao.save(directory);

        Directory directory1 = new Directory();
        directory1.setAuthor(user);
        directory1.setName("subDirectory");
        directory1.setParentDirectory(directory);
        directoryDao.save(directory1);

        //Note database test
        Note note = new Note();
        note.setAuthor(user);
        note.setDirectory(directory);
        note.setContent("Test Note Content");
        note.setTitle("Test note");

        noteDao.save(note);

        Note note2 = new Note();
        note2.setAuthor(user);
        note2.setDirectory(directory);
        note2.setContent("Test Note2 Content");
        note2.setTitle("Test note2");

        noteDao.save(note2);

        System.out.println(noteDao.getAllNotes());

        return "redirect:login";

    }
}
