package pl.coderslab.catalog;



import pl.coderslab.catalog.Catalog;

import java.util.List;

public interface CatalogService {

    void saveCatalog(Catalog catalog);

    Catalog getCatalogById(Long id);

    List<Catalog> getAllCatalogs();

    public void updateCatalog(Catalog catalog);

    public void deleteCatalog(Catalog catalog);

}
