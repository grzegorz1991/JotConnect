package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import pl.coderslab.directory.DirectoryDao;
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

//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
//

}
