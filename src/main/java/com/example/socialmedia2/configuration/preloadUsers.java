package com.example.socialmedia2.configuration;

import com.example.socialmedia2.model.User;
import com.example.socialmedia2.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class preloadUsers implements CommandLineRunner {

    UserRepository userRepository;

    public preloadUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User someUser = new User();
        User anotherUser = new User();
        someUser.setUsername("Hyper-Birger");
        someUser.setDescription("King of the social medias!!");
        anotherUser.setUsername("Joe handsome");
        anotherUser.setDescription("Dah man of insta");
        userRepository.save(someUser);
        userRepository.save(anotherUser);
    }
}
