package com.example.socialmedia2.controllers;

import com.example.socialmedia2.dto.DTOHashtag;
import com.example.socialmedia2.model.Hashtag;
import com.example.socialmedia2.model.Post;
import com.example.socialmedia2.repositories.HashtagRepository;
import com.example.socialmedia2.repositories.PostRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("api/hashtags")
public class HashtagRestController {

    HashtagRepository hashtagRepository;
    PostRepository postRepository;

    public HashtagRestController(HashtagRepository hashtagRepository, PostRepository postRepository) {
        this.hashtagRepository = hashtagRepository;
        this.postRepository = postRepository;
    }

    //Get all hashtags : works (returns empty array for now)
    @GetMapping
    List<Hashtag> getAllHashtags(){
        return hashtagRepository.findAll();
    }

    //Add hashtags to a post
    @PostMapping("/post/{id}/add-hashtags")
    void addHashtag(@PathVariable("id") int id, @RequestBody HashMap<String, String> jsonHashtags){
        System.out.println(jsonHashtags);
        Post post = postRepository.findById(id).get();
        System.out.println(post);
        Set<Hashtag> postHashtags = new HashSet<>();

        jsonHashtags.forEach( (String key, String name) -> {
                //Instansiate new hashtag
                Hashtag newHashtag = new Hashtag();
                newHashtag.setId(newHashtag.getId());
                //newHashtag.setPostNo(post.getId());
                System.out.println(key +" "+ name);
                newHashtag.setName(jsonHashtags.get(key));
                newHashtag.getPosts().add(post);
                hashtagRepository.save(newHashtag);
                postHashtags.add(newHashtag);
            }
        );

        if(post.getHashtags().isEmpty())post.setHashtags(postHashtags);
        /*Hashtag newHashtag = new Hashtag();
        System.out.println(hashtag);

        newHashtag.setId(newHashtag.getId());
        newHashtag.setName(hashtag.getName());
        newHashtag.setPostNo(id);
        newHashtag.setPost(post);

        System.out.println(newHashtag);
        hashtagRepository.save(newHashtag);
        post.addHashtag(newHashtag);*/
    }

    //Get hashtags by post id
    @GetMapping("/{id}")
    List<Hashtag> getUserHastags(@PathVariable("id") int id){
        return null;
    }

}
