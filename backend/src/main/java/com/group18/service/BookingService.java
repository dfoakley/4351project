package com.group18.service;

import com.group18.entities.Booking;
import com.group18.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    BookingRepository repository;

    public Booking getBooking(Integer bookingNumber) {
        Optional<Booking> booking = repository.findByBookingNumber(bookingNumber);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            return null;
        }
    }

    public void createBooking(Booking booking) { repository.save(booking); }
}
