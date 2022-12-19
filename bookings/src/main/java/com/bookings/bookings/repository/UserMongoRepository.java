package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<UserDto,String> {
}
