package pl.coderslab.note;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDao noteDao;

    private final UserService userService;

    @Autowired
    public NoteServiceImpl(NoteDao noteDao, UserService userService) {
        this.noteDao = noteDao;
        this.userService = userService;
    }

    @Override
    public void save(Note note) {

        noteDao.saveNote(note);
    }

    @Override
    public Note findById(Long id) {
        return noteDao.findNoteById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }



    @Override
    public List<Note> getUserNotes(User user) {
        return noteDao.findByUser(user);
    }
//    @Override
//    public List<Note> getUserNotes(User user) {
//        List<Note> userNotes = noteDao.findByUser(user);
//
//        // Initialize the lazily loaded properties
//        userNotes.forEach(note -> {
//            Hibernate.initialize(note.getAuthor());
//            Hibernate.initialize(note.getDirectory());
//        });
//
//        return userNotes;
//}
    @Override
    public void deleteById(Long id) {
        noteDao.deleteById(id);
    }

}
