package com.bookings.bookings.repository;

import com.bookings.bookings.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User,String> {
    Optional<User> findByEmail(String email);
}
