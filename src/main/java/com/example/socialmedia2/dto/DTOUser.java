package com.example.socialmedia2.dto;

import com.example.socialmedia2.model.Post;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DTOUser {

    private String username;
    private String description;

    public DTOUser(String username, String description) {
        this.username = username;
        this.description = description;
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

}
