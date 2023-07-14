package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Note;
import pl.coderslab.dao.NoteDAO;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDao;

    @Override
    public void saveNote(Note note) {
        noteDao.save(note);
    }
}
