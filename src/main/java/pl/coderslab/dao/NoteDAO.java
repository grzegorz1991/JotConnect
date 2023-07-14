package pl.coderslab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Note;

@Repository
public class NoteDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public NoteDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.save(note);
    }

    public Note getNoteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Note.class, id);
    }

}
