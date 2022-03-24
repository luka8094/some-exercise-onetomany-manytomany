package com.example.socialmedia2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;

    private String author;
    private int authorId;
    private String text;

    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date(System.currentTimeMillis()) ;

    //private Date modifiedDate

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="user_id")
    User user;

    //@OneToMany( cascade = CascadeType.ALL, mappedBy = "post")
    //private List<Hashtag> hashtags = new ArrayList<>();

    @ManyToMany
    @JoinTable( name ="post_hashtag",
            joinColumns = @JoinColumn(name ="post_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags = new HashSet<>();

    //public Post(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Set<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    /*
    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public void addHashtag(Hashtag hashtag){
        hashtags.add(hashtag);
    }*/

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", user=" + user +
                '}';
    }
}
