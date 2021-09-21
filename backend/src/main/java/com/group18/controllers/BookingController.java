package com.group18.controllers;

import com.group18.entities.Booking;
import com.group18.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/{bookingNumber}", produces = "application/json")
    public ResponseEntity<Booking> getBooking (
            @PathVariable("bookingNumber") Integer bookingNumber
    ) {
        Booking booking = bookingService.getBooking(bookingNumber);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Booking> createBooking (
            @RequestBody Booking booking
    ) {
        bookingService.createBooking(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.CREATED);
    }
}
