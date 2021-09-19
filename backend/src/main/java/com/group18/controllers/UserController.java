package com.group18.controllers;

import com.group18.entities.User;
import com.group18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{userNumber}", produces = "application/json")
    public ResponseEntity<User> getUser (
        @PathVariable("userNumber") Integer userNumber
    ) {
        User user = userService.getUser(userNumber);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<User> createUser (
            @RequestBody User user
    ) {
        userService.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
