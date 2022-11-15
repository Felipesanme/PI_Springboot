package com.bookings.bookings.repository;

import com.bookings.bookings.model.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserDto,Long> {
}
