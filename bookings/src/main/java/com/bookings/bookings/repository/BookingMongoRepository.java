package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookingMongoRepository extends MongoRepository<BookingDto,String> {
    Optional<BookingDto> findByEmail(String email);
}
