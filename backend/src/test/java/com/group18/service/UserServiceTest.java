package com.group18.service;

import com.group18.entities.User;
import com.group18.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    User user;

    Integer id = 0;
    String name = "John Doe";
    String phoneNumber = "1234567890";
    String email = "test@test.com";
    String userName = "john12";
    String passWord = "doe12";
    String mailingAddress = "1234 Maple St, City ZipCode";
    String billingAddress = "1234 Maple St, City ZipCode";
    Integer dinerNumber = 0;
    Integer points = 0;
    String preferredPayment = "cc";

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Before
    public void InitEntity() {
         user = new User(id, name, phoneNumber, email, userName, passWord, mailingAddress, billingAddress, dinerNumber, points, preferredPayment);
    }

    @Test
    public void shouldGetUser() throws Exception {
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        User result = userService.getUser(id);
        assertEquals(id, result.getId());
    }

    @Test
    public void shouldGetUsername() throws Exception {
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(user));
        User result = userService.getUsername(userName);
        assertEquals(userName, result.getUserName());
    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(user);
        when(userRepository.findAll()).thenReturn(listUsers);

        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        User result = userService.deleteUser(id);
        verify(userRepository).delete(any(User.class));
    }

    @Test
    public void shouldDeleteAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userService.deleteAllUsers();
        verify(userRepository).deleteAll();
    }

}
