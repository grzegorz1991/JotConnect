package pl.coderslab.directory;

import java.util.List;

public interface DirectoryService {
    List<Directory> getAllDirectories();

    List<Directory> getDirectoriesByUserId(Long userId);

}
