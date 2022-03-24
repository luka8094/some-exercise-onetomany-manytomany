package com.example.socialmedia2.dto;

import com.example.socialmedia2.model.Hashtag;
import com.example.socialmedia2.model.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Set;

public class DTOPost {

    private String author;
    private String text;
    private Date created;
    private Set<Hashtag> hashtagSet;

    public DTOPost(String author, String text, Date created) {
        this.author = author;
        this.text = text;
        this.created = created;
    }

    /*public DTOPost(String author, String text, Date created, Set<Hashtag> hashtagSet) {
        this.author = author;
        this.text = text;
        this.created = created;
        this.hashtagSet = hashtagSet;
    }*/

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Hashtag> getHashtagSet() {
        return hashtagSet;
    }

    public void setHashtagSet(Set<Hashtag> hashtagSet) {
        this.hashtagSet = hashtagSet;
    }
}
