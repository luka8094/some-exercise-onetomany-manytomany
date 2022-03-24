package com.example.socialmedia2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;

    @Column( nullable = false)
    private String username;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    //@JoinColumn( name = "user_id")
    //@JsonBackReference
    private List<Post> posts = new ArrayList<>();

    //public User(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addNewPost(Post post){
        posts.add(post);
    }
}
