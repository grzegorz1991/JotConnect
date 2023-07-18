package pl.coderslab.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.user.User;

@Controller
@Transactional
public class CatalogController {

    @Autowired
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @GetMapping("/createCatalog")
    @ResponseBody

    public String addCatalog() {
        // Create a test catalog
        Catalog catalog = new Catalog("Test Catalog", new User());

        // Save the catalog using the catalogService
        catalogService.saveCatalog(catalog);

        // Return a response or redirect to another page
        System.out.println("Created catalog");
        return "Catalog created and saved successfully!";
    }
}
