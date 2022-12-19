package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<BookingDto,String> {
}
