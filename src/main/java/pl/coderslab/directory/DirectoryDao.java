package pl.coderslab.directory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectoryDao {

    Directory findById(Long id);

    void save(Directory directory);

    void update(Directory directory);

    void delete(Directory directory);

    List<Directory> getAllDirectories();

    List<Directory> getDirectoriesByParent(Directory parentDirectory);

    List<Directory> findDirectoriesByAuthorId(Long authorId);
}
