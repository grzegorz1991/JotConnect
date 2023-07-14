package pl.coderslab.service;

import java.util.List;

import pl.coderslab.entity.Catalog;

public interface CatalogService {

    List<Catalog> getAllCatalogs();

    Catalog getCatalogById(Long id);

    void saveCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(Long id);

}
