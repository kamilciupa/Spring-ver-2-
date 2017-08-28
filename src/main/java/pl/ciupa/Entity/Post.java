package pl.ciupa.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kamil on 2017-08-22.
 */

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob @Column(nullable = false)
    private String body;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Blogers author;

    @Column(nullable = false)
    private Date date = new Date();

    public Post() {
    }

    public Post(String title, String body, Blogers author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(Long id, String title, String body, Blogers author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Blogers getAuthor() {
        return author;
    }

    public void setAuthor(Blogers author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author +
                ", date=" + date +
                '}';
    }
}
