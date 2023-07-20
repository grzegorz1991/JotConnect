package pl.coderslab.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.directory.Directory;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directory> directories;

    public User() {
        directories = new ArrayList<>();
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        directories = new ArrayList<>();
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

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
        directory.setAuthor(this);
    }

    public void removeDirectory(Directory directory) {
        directories.remove(directory);
        directory.setAuthor(null);
    }

    public String getUserType(){

        if(username != null){
            if(getUsername().equals("Admin")){
                return UserType.MASTER_ADMIN.toString();
            }
            else if(isAdmin()){
                return UserType.ADMIN.toString();
            }
            else
                return UserType.USER.toString();
        }
        else{
            return UserType.GUEST.toString();
        }


    }
}
