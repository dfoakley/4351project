package com.group18.service;

import com.group18.entities.User;
import com.group18.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public Optional<User> findByToken(String token) {
        return repository.findById(token);
    }

    public Optional<String> login(String username, String password) {
        Optional<User> foundUser = repository.findByUserName(username);
        if(foundUser.isPresent() && password.equals(foundUser.get().getPassword())) {
            final String uuid = UUID.randomUUID().toString();
            final User user = User
                    .builder()
                    .id(uuid)
                    .passWord(password)
                    .userName(username)
                    .build();
            return Optional.of(uuid);
        }
        return Optional.empty();
    }

    void logout(User user) {

    }
}
