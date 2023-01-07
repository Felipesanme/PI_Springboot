package com.bookings.bookings.repository;

import com.bookings.bookings.model.Booking;
import com.bookings.bookings.model.BookingDto;

import java.util.List;

public interface BookingRepositoryDao {
    List<Booking> getAllBookings();
    Booking findBookingById(String idBooking);
    Booking createBooking(BookingDto bookingDto);
    Booking updateBooking (String idBooking, BookingDto bookingDto);
    Boolean deleteBooking(String idBooking);

    Booking findByEmail(String email);
}
