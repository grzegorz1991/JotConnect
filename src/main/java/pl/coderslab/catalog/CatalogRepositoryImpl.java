package pl.coderslab.catalog;

import org.springframework.stereotype.Repository;
import pl.coderslab.catalog.Catalog;
import pl.coderslab.catalog.CatalogRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CatalogRepositoryImpl implements CatalogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Catalog> getAllCatalogs() {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c", Catalog.class);
        return query.getResultList();
    }

    @Override
    public Catalog getCatalogById(Long id) {
        return entityManager.find(Catalog.class, id);
    }

    @Override
    public void saveCatalog(Catalog catalog) {
        entityManager.persist(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        entityManager.merge(catalog);
    }

    @Override
    public void deleteCatalog(Catalog catalog) {
        entityManager.remove(entityManager.contains(catalog) ? catalog : entityManager.merge(catalog));
    }
}
