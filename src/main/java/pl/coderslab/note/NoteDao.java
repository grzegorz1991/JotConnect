package pl.coderslab.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.directory.Directory;
import pl.coderslab.user.User;

import java.util.List;

@Repository
public interface NoteDao  {
    Note findNoteById(Long id);

    void saveNote(Note note);

    void update(Note note);

    void delete(Note note);

    List<Note> getAllNotes();

    List<Note> getNotesByUser(User user);

    List<Note> getNotesByDirectory(Directory directory);

    List<Note> searchNotesByKeyword(String keyword);

    List<Note> getRecentNotes(int limit);
}
