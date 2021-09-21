package com.group18.repository;

import com.group18.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public Optional<Booking> findByBookingNumber(Integer bookingNumber);
}
