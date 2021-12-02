package com.group18.service;

import com.group18.entities.BookTable;
import com.group18.repository.BookTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookTableService {
    @Autowired
    BookTableRepository repository;

    public BookTable getBookTable(Integer bookingNumber) {
        Optional<BookTable> bookTable = repository.findById(bookingNumber);
        if (bookTable.isPresent()) {
            return bookTable.get();
        } else {
            return null;
        }
    }

    public BookTable deleteBookTable(Integer bookingNumber) {
        Optional<BookTable> bookTable = repository.findById(bookingNumber);
        if (bookTable.isPresent()) {
            repository.delete(bookTable.get());
            return bookTable.get();
        } else {
            return null;
        }
    }

    public void createBookTable(BookTable bookTable) { repository.save(bookTable); }
}
