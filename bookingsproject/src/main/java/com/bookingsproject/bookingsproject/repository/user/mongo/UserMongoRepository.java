package com.bookingsproject.bookingsproject.repository.user.mongo;

import com.bookingsproject.bookingsproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);

}
