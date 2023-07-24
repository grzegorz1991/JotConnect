package pl.coderslab.directory;

import java.util.List;

public interface DirectoryService {
    List<Directory> getAllDirectories();

    List<Directory> getDirectoriesByUserId(Long userId);

    Directory saveDirectory(Directory directory);

    Directory getDirectoryById(Long id);

    Directory updateDirectory(Directory directory);

    void deleteDirectory(Long id);

}
