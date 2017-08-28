package pl.ciupa.Entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kamil on 2017-08-22.
 */


@Entity
@Table(name = "bloggers")
public class Blogers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(length = 60)
    private String passwordHash;

    @Column(length = 100)
    private String fullName;

    @OneToMany(mappedBy = "author")
    private Set<Post> post = new HashSet<Post>();

    public Blogers(){

    }
    public Blogers(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }
    public Blogers(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Blogers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", fullName='" + fullName + '\'' +
                ", post=" + post +
                '}';
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
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Set<Post> getPost() {
        return post;
    }
    public void setPost(Set<Post> post) {
        this.post = post;
    }
}
