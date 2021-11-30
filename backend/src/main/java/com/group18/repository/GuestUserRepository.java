package com.group18.repository;

import com.group18.entities.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestUserRepository extends JpaRepository<GuestUser, Integer> {
    public Optional<GuestUser> findById(Integer id);
}
