package pl.coderslab.directory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryDao directoryDao;

    @Autowired
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

    @Override
    public Directory saveDirectory(Directory directory) {
        directoryDao.save(directory);
        return directory;
    }

    @Override
    public Directory getDirectoryById(Long id) {
        return directoryDao.findById(id);
    }

    @Override
    public Directory updateDirectory(Directory directory) {
        directoryDao.update(directory);
        return directory;
    }

    @Override
    public void deleteDirectory(Long id) {
        directoryDao.delete(directoryDao.findById(id));
    }

}
