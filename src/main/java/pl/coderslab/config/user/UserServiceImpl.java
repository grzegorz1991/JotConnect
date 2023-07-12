package pl.coderslab.config.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserDAO userDao;
	private final BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserDAO userDao, BCryptPasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void addUser(User user) {

		userDao.addUser(user);
	}

	@Override
	public boolean login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user != null) {
			System.out.println(user.getPassword()+ "userServiceImpl login() user getPassword");
			return passwordEncoder.matches(password, user.getPassword());
		}
		return false;
	}
}
