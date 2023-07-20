package pl.coderslab.user;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao {

    public void saveUser(User employee);

    public void login(User user);

    User findByUsername(String username);

    User findByEmail(String email);

}