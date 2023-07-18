package pl.coderslab.catalog;


import pl.coderslab.catalog.Catalog;

import java.util.List;

public interface CatalogRepository {
    List<Catalog> getAllCatalogs();

    Catalog getCatalogById(Long id);

    void saveCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(Catalog catalog);
}
