package pl.coderslab.directory;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DirectoryDaoImpl implements DirectoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Directory directory) {
        entityManager.persist(directory);
    }


    @Override
    public Directory findById(Long id) {
        return entityManager.find(Directory.class, id);
    }


    @Override
    public void update(Directory directory) {
        entityManager.merge(directory);
    }

    @Override
    public void delete(Directory directory) {
        entityManager.remove(directory);
    }

    @Override
    public List<Directory> getAllDirectories() {
        TypedQuery<Directory> query = entityManager.createQuery("SELECT d FROM Directory d", Directory.class);
        return query.getResultList();
    }

    @Override
    public List<Directory> getDirectoriesByParent(Directory parentDirectory) {
        TypedQuery<Directory> query = entityManager.createQuery("SELECT d FROM Directory d WHERE d.parentDirectory = :parent", Directory.class);
        query.setParameter("parent", parentDirectory);
        return query.getResultList();
    }

    @Override
    public List<Directory> findDirectoriesByAuthorId(Long authorId) {
        String jpql = "SELECT d FROM Directory d WHERE d.author.id = :authorId";
        return entityManager.createQuery(jpql, Directory.class)
                .setParameter("authorId", authorId)
                .getResultList();
    }


}
