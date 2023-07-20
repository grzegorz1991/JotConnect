package pl.coderslab.user;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    public void addUser(User employee);

    @Transactional
    boolean login(String username, String password);

    @Transactional
    User findByUsername(String username);
    @Transactional
    User findByEmail(String email);

    boolean isUsernameExists(String username);

    boolean isEmailExists(String email);

}