package com.group18.service;

import com.group18.entities.GuestUser;
import com.group18.repository.GuestUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GuestUserServiceTest {
    GuestUser guestUser;

    Integer id = 0;
    String name = "bob";
    Integer phoneNumber = 1234567;
    String email = "bob@test.com";

    @InjectMocks
    GuestUserService guestUserService;
    @Mock
    GuestUserRepository guestUserRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Before
    public void InitEntity() {
        guestUser = new GuestUser(id, name, phoneNumber, email);
    }

    @Test
    public void shouldGetGuestUser() throws Exception {
        when(guestUserRepository.findById(anyInt())).thenReturn(Optional.of(guestUser));
        GuestUser result = guestUserService.getGuestUser(id);
        assertEquals(id, result.getId());
    }

    @Test
    public void shouldDeleteGuestUser() throws Exception {
        when(guestUserRepository.findById(anyInt())).thenReturn(Optional.of(guestUser));

        GuestUser result = guestUserService.deleteGuestUser(id);
        verify(guestUserRepository).delete(any(GuestUser.class));
    }

}
