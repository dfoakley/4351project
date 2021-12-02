package com.group18.repository;

import com.group18.entities.ResTable;
import com.group18.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findById(Integer id);
    public Optional<User> findByUserName(String userName);
    public List<User> findAll();
}
