package com.group18.controllers;

import com.group18.dto.UserBean;
import com.group18.entities.ResTable;
import com.group18.entities.User;
import com.group18.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/getUserId/{id}", produces = "application/json")
    public ResponseEntity<User> getUserByNumber (
        @PathVariable("id") Integer id
    ) {
        User user = userService.getUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/getUserName/{userName}", produces = "application/json")
    public ResponseEntity<User> getUserName (
            @PathVariable("userName") String userName
    ) {
        User user = userService.getUsername(userName);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllUsers", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers (

    ) {
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<User> createUser (
            @RequestBody User user
    ) {
        userService.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{userNumber}", produces = "application/json")
    public ResponseEntity<User> getUser (
            @PathVariable("userNumber") Integer userNumber
    ) {
        User user = userService.deleteUser(userNumber);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<User> deleteAllUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
