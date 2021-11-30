package com.group18.controllers;

import com.group18.entities.BookTable;
import com.group18.service.BookTableService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BookTable")
public class BookTableController {
    @Autowired
    BookTableService bookTableService;

    @GetMapping(value = "/{bookingNumber}", produces = "application/json")
    public ResponseEntity<BookTable> getBookTable (
            @PathVariable("bookingNumber") Integer bookingNumber
    ) {
        BookTable bookTable = bookTableService.getBookTable(bookingNumber);
        return new ResponseEntity<BookTable>(bookTable, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bookingNumber}", produces = "application/json")
    public ResponseEntity<BookTable> deleteBookTable (
            @PathVariable("bookingNumber") Integer bookingNumber
    ) {
        BookTable bookTable = bookTableService.deleteBookTable(bookingNumber);
        return new ResponseEntity<BookTable>(bookTable, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<BookTable> createBookTable (
            @RequestBody BookTable bookTable
    ) {
        bookTableService.createBookTable(bookTable);
        return new ResponseEntity<BookTable>(bookTable, HttpStatus.CREATED);
    }

}
