package pl.coderslab.config.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.config.user.User;

@Repository
@Transactional
public interface UserDAO {

	public void addUser(User employee);
	public void login(User user);
	
}
