package pl.coderslab.note;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.directory.Directory;
import pl.coderslab.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class NoteDaoImpl implements NoteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Note findNoteById(Long id) {
        return entityManager.find(Note.class, id);
    }

    @Override
    public void saveNote(Note note) {
        entityManager.persist(note);
    }

    @Override
    public void update(Note note) {
        entityManager.merge(note);
    }

    @Override
    public void delete(Note note) {
        entityManager.remove(note);
    }

    @Override
    public List<Note> getAllNotes() {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n", Note.class);
        return query.getResultList();
    }

    @Override
    public List<Note> getNotesByUser(User user) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n WHERE n.author = :user", Note.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public List<Note> getNotesByDirectory(Directory directory) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n WHERE n.directory = :directory", Note.class);
        query.setParameter("directory", directory);
        return query.getResultList();
    }

    @Override
    public List<Note> searchNotesByKeyword(String keyword) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n WHERE n.title LIKE :keyword OR n.content LIKE :keyword", Note.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    @Override
    public List<Note> getRecentNotes(int limit) {
        TypedQuery<Note> query = entityManager.createQuery("SELECT n FROM Note n ORDER BY n.createdDate DESC", Note.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}