package com.bookingsproject.bookingsproject.repository.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.model.Booking;


import java.util.List;

public interface BookingRepository {

    List<Booking> findAll();
    Booking findById(String id);
    Booking createBooking(BookingDto bookingDto);
    Booking updateBooking(String id, BookingDto bookingDto);
    Boolean deleteBooking(String id);
    Booking findByEmail(String email);
}
