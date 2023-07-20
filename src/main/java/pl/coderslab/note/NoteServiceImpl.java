package pl.coderslab.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteServiceImpl(NoteDao noteRepository) {
        this.noteDao = noteRepository;
    }

    @Override
    public void save(Note note) {
        // Add any additional business logic before saving the note, if needed
        noteDao.saveNote(note);
    }

    // Implement other methods of the NoteService interface as needed
}
