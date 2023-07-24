package pl.coderslab.note;

import pl.coderslab.user.User;

import java.util.List;


public interface NoteService {

    void save(Note note);

    Note findById(Long id);

    List<Note> getAllNotes();

    List<Note> getUserNotes(User user);

    void deleteById(Long id);
}