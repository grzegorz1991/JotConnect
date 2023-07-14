package pl.coderslab.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDAO {

	public void addUser(User employee);
	public void login(User user);
	User findByUsername(String username);
	User findByEmail(String email);
	
}
