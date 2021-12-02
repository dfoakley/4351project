package com.group18.controllers;

import com.group18.entities.Booking;
import com.group18.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/getBooking/{bookingNumber}", produces = "application/json")
    public ResponseEntity<Booking> getBooking (
            @PathVariable("bookingNumber") Integer bookingNumber
    ) {
        Booking booking = bookingService.getBooking(bookingNumber);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllBookings", produces = "application/json")
    public ResponseEntity<List<Booking>> getAllBooking (

    ) {
        List<Booking> booking = bookingService.getAllBooking();
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bookingNumber}", produces = "application/json")
    public ResponseEntity<Booking> deleteBooking (
            @PathVariable("bookingNumber") Integer bookingNumber
    ) {
        Booking booking = bookingService.deleteUser(bookingNumber);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllBookings")
    public ResponseEntity<Booking> deleteAllBookings() {
        bookingService.deleteAllBookings();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Booking> createBooking (
            @RequestBody Booking booking
    ) {
        bookingService.createBooking(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
    }
}
