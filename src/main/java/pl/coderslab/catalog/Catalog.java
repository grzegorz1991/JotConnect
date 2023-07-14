package pl.coderslab.catalog;
import pl.coderslab.note.Note;
import pl.coderslab.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String creationDate;
    private String modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_catalog_id")
    private Catalog parentCatalog;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL)
    private List<Note> notes;

    public Catalog(Long id, String name, String creationDate, String modificationDate, User user, Catalog parentCatalog, List<Note> notes) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.user = user;
        this.parentCatalog = parentCatalog;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalog getParentCatalog() {
        return parentCatalog;
    }

    public void setParentCatalog(Catalog parentCatalog) {
        this.parentCatalog = parentCatalog;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
