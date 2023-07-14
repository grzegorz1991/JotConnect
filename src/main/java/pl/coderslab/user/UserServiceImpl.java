package pl.coderslab.user;

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

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public boolean findByEmail(String email) {
		return false;
	}


	@Override
	public boolean isUsernameExists(String username) {
		User user = userDao.findByUsername(username);
		return user != null;
	}

	@Override
	public boolean isEmailExists(String email) {
		User user = userDao.findByEmail(email);
		return user != null;
	}
}
