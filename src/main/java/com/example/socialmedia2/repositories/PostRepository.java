package com.example.socialmedia2.repositories;

import com.example.socialmedia2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> getPostsByAuthorId(Integer authorId);
}
