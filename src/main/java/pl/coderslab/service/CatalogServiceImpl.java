package pl.coderslab.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Catalog;
import pl.coderslab.repository.CatalogRepository;

import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog getCatalogById(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCatalog(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void deleteCatalog(Long id) {
        catalogRepository.deleteById(id);
    }
}
