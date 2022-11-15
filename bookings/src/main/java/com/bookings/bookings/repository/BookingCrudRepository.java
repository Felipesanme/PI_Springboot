package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;
import org.springframework.data.repository.CrudRepository;

public interface BookingCrudRepository extends CrudRepository<BookingDto,Long> {
}
