package com.bookings.bookings.repository;

import com.bookings.bookings.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookingMongoRepository extends MongoRepository<Booking,String> {
    Optional<Booking> findByEmail(String email);
}
