package pl.coderslab.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Catalog;

@Repository
public class CatalogDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CatalogDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCatalog(Catalog catalog) {
        Session session = sessionFactory.getCurrentSession();
        session.save(catalog);
    }

    public Catalog getCatalogById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Catalog.class, id);
    }

}
