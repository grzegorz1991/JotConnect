package pl.coderslab.note;

import pl.coderslab.directory.Directory;
import pl.coderslab.user.User;

import java.util.List;

public interface NoteDao {
    Note findById(Long id);

    void save(Note note);

    void update(Note note);

    void delete(Note note);

    List<Note> getAllNotes();

    List<Note> getNotesByUser(User user);

    List<Note> getNotesByDirectory(Directory directory);

    List<Note> searchNotesByKeyword(String keyword);

    List<Note> getRecentNotes(int limit);
}
