package com.group18.controllers;

import com.group18.entities.GuestUser;
import com.group18.service.GuestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GuestUser")
@CrossOrigin
public class GuestUserController {
    @Autowired
    GuestUserService guestUserService;

    @GetMapping(value = "/{guestNumber}", produces = "application/json")
    public ResponseEntity<GuestUser> getGuestUser (
            @PathVariable("guestNumber") Integer guestNumber
    ) {
        GuestUser guestUser = guestUserService.getGuestUser(guestNumber);
        return new ResponseEntity<GuestUser>(guestUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{guestNumber}", produces = "application/json")
    public ResponseEntity<GuestUser> deleteGuestUser (
            @PathVariable("guestNumber") Integer guestNumber
    ) {
        GuestUser guestUser = guestUserService.deleteGuestUser(guestNumber);
        return new ResponseEntity<GuestUser>(guestUser, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<GuestUser> createGuestUser (
            @RequestBody GuestUser guestUser
    ) {
        guestUserService.createGuestUser(guestUser);
        return new ResponseEntity<GuestUser>(guestUser, HttpStatus.CREATED);
    }
}
