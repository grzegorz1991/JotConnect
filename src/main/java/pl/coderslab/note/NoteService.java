package pl.coderslab.note;

import org.springframework.transaction.annotation.Transactional;

public interface NoteService {
    @Transactional
    void saveNote(Note note);
}