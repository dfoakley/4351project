package com.group18.service;

import com.group18.entities.User;
import com.group18.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User getUser(Integer userNumber) {
        Optional<User> user = repository.findById(userNumber);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public void createUser(User user) {
        repository.save(user);
    }
}
