package pl.coderslab.note;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl implements NoteDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public NoteDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNote(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.save(note);
    }

    public Note getNoteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Note.class, id);
    }

    // Other methods as needed
}
