package com.example.socialmedia2.repositories;

import com.example.socialmedia2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}
