package com.group18.service;

import com.group18.entities.GuestUser;
import com.group18.repository.GuestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestUserService {
    @Autowired
    GuestUserRepository repository;

    public GuestUser getGuestUser(Integer id) {
        Optional<GuestUser> guestUser = repository.findById(id);
        if (guestUser.isPresent()) {
            return guestUser.get();
        } else {
            return null;
        }
    }

    public GuestUser deleteGuestUser(Integer id) {
        Optional<GuestUser> guestUser = repository.findById(id);
        if (guestUser.isPresent()) {
            repository.delete(guestUser.get());
            return  guestUser.get();
        } else {
            return null;
        }
    }

    public void createGuestUser(GuestUser guestUser) { repository.save(guestUser); }
}
