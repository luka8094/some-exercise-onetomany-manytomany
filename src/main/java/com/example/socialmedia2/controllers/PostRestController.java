package com.example.socialmedia2.controllers;

import com.example.socialmedia2.dto.DTOPost;
import com.example.socialmedia2.model.Post;
import com.example.socialmedia2.model.User;
import com.example.socialmedia2.repositories.HashtagRepository;
import com.example.socialmedia2.repositories.PostRepository;
import com.example.socialmedia2.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("api/posts")
public class PostRestController {

    PostRepository postRepository;
    UserRepository userRepository;
    HashtagRepository hashtagRepository;

    public PostRestController(PostRepository postRepository, UserRepository userRepository, HashtagRepository hashtagRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.hashtagRepository = hashtagRepository;
    }

    //Get all posts : works
    @GetMapping
    List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    //Add a post by author id : seems to work
    //Post debugging : It works!
    @PostMapping("/user/{id}/new-post")
    void addAPostByAuthor(@PathVariable("id") Integer id, @RequestBody DTOPost post){
        User searchedUser = userRepository.findById(id).get();

        //Opret en ny instance af Post (DAO)
        Post newPost = new Post();
        System.out.println(newPost.getId());

        //Id'en til Post'en skal parses manuelt for den bliver registreret
        newPost.setId(newPost.getId());

        //Derefter udfyld objektet med de relevante data
        //fra Data Transfer Objektet: DTOPost
        newPost.setAuthor(searchedUser.getUsername());
        newPost.setAuthorId(searchedUser.getId());
        newPost.setText(post.getText());
        newPost.setUser(searchedUser);
        System.out.println(newPost);

        searchedUser.addNewPost(newPost);
        postRepository.save(newPost);
    }

    //Get all posts by author id :
    // Post debugging : finally works!!!
    @GetMapping("/user/{author_id}")
    List<Post> getPostsByAuthor(@PathVariable("author_id") int id){
        return postRepository.getPostsByAuthorId(id);
    }
}
