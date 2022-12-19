package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;

import java.util.List;

public interface BookingRepositoryDao {
    List<BookingDto> getAllBookings();
    BookingDto findBookingById(String idBooking);
    BookingDto createBooking(BookingDto bookingDto);
    boolean updateBooking (String idBooking, BookingDto bookingDto);
    boolean deleteBooking(String idBooking);
}
