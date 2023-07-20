package pl.coderslab.directory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryDao directoryDao;

    public DirectoryServiceImpl(DirectoryDao directoryDao) {
        this.directoryDao = directoryDao;
    }

    @Override
    public List<Directory> getAllDirectories() {
        return directoryDao.getAllDirectories();
    }

    @Override
    public List<Directory> getDirectoriesByUserId(Long userId) {
        return directoryDao.findDirectoriesByAuthorId(userId);
    }

}
