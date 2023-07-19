package pl.coderslab.directory;

import java.util.List;

public interface DirectoryDao {

    Directory findById(Long id);

    void save(Directory directory);

    void update(Directory directory);

    void delete(Directory directory);

    List<Directory> getAllDirectories();

    List<Directory> getDirectoriesByParent(Directory parentDirectory);
}
