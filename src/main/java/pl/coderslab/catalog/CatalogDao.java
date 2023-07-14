package pl.coderslab.catalog;

public interface CatalogDao {

    void addCatalog(Catalog catalog);

    Catalog getCatalogById(Long id);
}
