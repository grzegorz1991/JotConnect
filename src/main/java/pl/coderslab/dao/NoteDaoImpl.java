package pl.coderslab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Note;

@Repository
public class NoteDaoImpl implements NoteDaoInterface {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.save(note);
    }
}
