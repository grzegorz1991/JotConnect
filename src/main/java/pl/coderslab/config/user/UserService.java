package pl.coderslab.config.user;

import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.config.user.User;

public interface UserService {
	
	@Transactional
	public void addUser(User employee);
	@Transactional
	boolean login(String username, String password);

}
