package com.bookingsproject.bookingsproject.repository.booking.mongo;

import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookingMongoRepository extends MongoRepository<Booking,String> {
    Optional<Booking> findByEmail(String email);
}
