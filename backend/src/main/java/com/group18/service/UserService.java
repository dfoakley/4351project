package com.group18.service;

import com.group18.converter.UserConverter;
import com.group18.dto.UserBean;
import com.group18.entities.ResTable;
import com.group18.entities.User;
import com.group18.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User getUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public User getUsername(String name) {
        Optional<User> user = repository.findByUserName(name);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User deleteUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.delete(user.get());
            return user.get();
        } else {
            return null;
        }
    }

    public void createUser(UserBean bean) {
        User user = UserConverter.convert(bean);
        repository.save(user);
    }

    public void createUser(User user) {
        repository.save(user);
    }

    public Optional<User> findByToken(String token) {
        return null;
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }

    void logout(User user) {

    }
}
