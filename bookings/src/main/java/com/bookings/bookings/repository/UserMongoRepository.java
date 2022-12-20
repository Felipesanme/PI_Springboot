package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserDto,String> {
    Optional<UserDto> findByEmail(String email);
}
