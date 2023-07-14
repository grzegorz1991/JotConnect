package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

}
