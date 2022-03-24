package com.example.socialmedia2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hashtags")
public class Hashtag {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;

    //Post number (id)
    private String name;

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn( name = "post_id")
    Post post;
    */
    @ManyToMany( mappedBy = "hashtags")
    private Set<Post> posts = new HashSet<>();

    //public Hashtag(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
