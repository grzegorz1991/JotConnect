package pl.coderslab.note;

public interface NoteDao {
    void addNote(Note note);

    Note getNoteById(Long id);
}
