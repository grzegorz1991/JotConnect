package pl.coderslab.user;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.xml.catalog.Catalog;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Catalog> Catalogs;

    public User() {
        this.admin = false;
    }

    public List<Catalog> getCatalogs() {
        return Catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        Catalogs = catalogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("User.class - password String = " + password);
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("User.class - hashed password String = " + hashedPassword);
        this.password = hashedPassword;
    }

    public boolean checkPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, this.password);
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
