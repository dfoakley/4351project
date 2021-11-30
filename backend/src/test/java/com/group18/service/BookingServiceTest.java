package com.group18.service;

import com.group18.entities.Booking;
import com.group18.repository.BookingRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookingServiceTest {
    Booking booking;
    Booking oldbooking;

    Integer bookingNumber = 0;
    Integer userNumber = 0;
    Integer numGuests = 2;
    String dateTime = "11/15/2021";
    String ccInfo = "1234567890";
    Integer[] tablesBooked = new Integer[]{1,2,3,4,5};

    @InjectMocks
    BookingService bookingService;
    @Mock
    BookingRepository bookingRepository;

    @Before
    public void init() { MockitoAnnotations.initMocks(this); }

    @Before
    public void InitEntity() {
        booking = new Booking(bookingNumber, userNumber, numGuests, dateTime, ccInfo, tablesBooked);
        oldbooking = new Booking(bookingNumber, userNumber, numGuests, dateTime, ccInfo, tablesBooked);
    }

    @Test
    public void shouldGetBooking() throws Exception {
         when(bookingRepository.findByBookingNumber(anyInt())).thenReturn(Optional.of(booking));
         Booking result = bookingService.getBooking(bookingNumber);
         assertEquals(bookingNumber, result.getBookingNumber());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        Integer bookingNumber = 0;
        Integer userNumber = 0;
        Integer numGuests = 2;
        String dateTime = "11/15/2021";
        String ccInfo = "1234567890";
        Integer[] tablesBooked = {1,2,3,4,5};

        booking = new Booking(bookingNumber, userNumber, numGuests, dateTime, ccInfo, tablesBooked);
        oldbooking = new Booking(bookingNumber, userNumber, numGuests, dateTime, ccInfo, tablesBooked);
//        System.out.println(booking);

        when(bookingRepository.findByBookingNumber(anyInt())).thenReturn(Optional.of(booking));

        Booking result = bookingService.deleteUser(bookingNumber);
        System.out.println("result: "+ result);
        verify(bookingRepository).delete(any(Booking.class));
    }

    @Test
    public void shouldGetAllBooking() throws Exception {
        List<Booking> listBookings = new ArrayList<>();
        listBookings.add(booking);
        when(bookingRepository.findAll()).thenReturn(listBookings);

        List<Booking> result = bookingService.getAllBooking();
        assertEquals(1, result.size());
    }

    @Test
    public void shouldDeleteAllBookings() throws Exception {
        List<Booking> listBookings = new ArrayList<>();
        listBookings.add(booking);
        bookingService.deleteAllBookings();
        verify(bookingRepository).deleteAll();
    }
}
