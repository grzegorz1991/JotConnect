package pl.coderslab.config.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.coderslab.config.user.User;
import pl.coderslab.config.user.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
		query.setParameter("username", username);
		return query.uniqueResult();
	}

}