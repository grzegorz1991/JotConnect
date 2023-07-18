package pl.coderslab.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.catalog.Catalog;
import pl.coderslab.catalog.CatalogRepository;
import pl.coderslab.catalog.CatalogService;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.getAllCatalogs();
    }

    @Override
    public Catalog getCatalogById(Long id) {
        return catalogRepository.getCatalogById(id);
    }

    @Override
    public void saveCatalog(Catalog catalog) {
        catalogRepository.saveCatalog(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        catalogRepository.updateCatalog(catalog);
    }

    @Override
    public void deleteCatalog(Catalog catalog) {
        catalogRepository.deleteCatalog(catalog);
    }
}
