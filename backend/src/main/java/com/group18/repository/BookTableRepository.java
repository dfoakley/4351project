package com.group18.repository;

import com.group18.entities.BookTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookTableRepository extends JpaRepository<BookTable, Integer> {
    public Optional<BookTable> findById(Integer bookingNumber);
    public List<BookTable> findAll();
}
