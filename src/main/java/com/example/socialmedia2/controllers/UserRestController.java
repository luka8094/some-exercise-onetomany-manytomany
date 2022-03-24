package com.example.socialmedia2.controllers;


import com.example.socialmedia2.dto.DTOUser;
import com.example.socialmedia2.model.User;
import com.example.socialmedia2.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserRestController {

    UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Get all users : works
    @GetMapping
    List<User> getAllUsers(){
        //TODO: get all users
        return userRepository.findAll();
    }

    //Create an user : works
    @PostMapping("/{id}")
    void createAnUser(@PathVariable("id") int id, @RequestBody DTOUser user){
        if(userRepository.findById(id).isPresent()) System.out.println("sorry, the user already exists in the system");
        User newUser = new User();
        newUser.setId(id);
        newUser.setUsername(user.getUsername());
        newUser.setDescription(user.getDescription());
        userRepository.save(newUser);
    }

    //Get one user : works (with Optional)
    @GetMapping("/{id}")
    User getAnUser(@PathVariable("id") int id){
        //TODO: get a user
        return userRepository.findById(id).get();
    }


    //Update an user : works (despite warning in console)
    @PutMapping("/{id}")
    void updateAnUSer(@PathVariable("id") int id, @RequestBody DTOUser user){
        //TODO: update an user
        System.out.println(user);
        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setUsername(user.getUsername());
        updateUser.setDescription(user.getDescription());
        System.out.println(updateUser);
        userRepository.save(updateUser);
    }

    //Delete an user : works
    @DeleteMapping("/{id}")
    void deleteAnUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }
}
