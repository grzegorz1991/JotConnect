package pl.coderslab.catalog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogDaoImpl implements CatalogDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public CatalogDaoImpl(SessionFactory sessionFactory) {
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

    // Other methods as needed
}
