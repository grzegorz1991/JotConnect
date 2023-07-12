package pl.coderslab.config.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "admin")
	private boolean admin;

	public User() {
		this.admin = false; // Set the admin field to false by default
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		// Hash the password using Bcrypt and store the hashed value
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = hashedPassword;
	}
	public boolean checkPassword(String password) {
		// Compare the provided password with the stored hashed password
		return BCrypt.checkpw(password, this.password);
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
