package com.group18.service;

import com.group18.entities.Booking;
import com.group18.entities.User;
import com.group18.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
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

    public Booking deleteUser(Integer bookingNumber) {
        Optional<Booking> booking = repository.findByBookingNumber(bookingNumber);
        if (booking.isPresent()) {
            System.out.println(booking);
            repository.delete(booking.get());
            return booking.get();
        } else {
            return null;
        }
    }

    public List<Booking> getAllBooking() {
        return repository.findAll();
    }

    public void deleteAllBookings() { repository.deleteAll(); }

    public void createBooking(Booking booking) { repository.save(booking); }
}
