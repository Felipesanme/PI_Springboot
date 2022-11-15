package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;

import java.util.List;

public interface BookingRepositoryDao {
    List<BookingDto> getAllBookings();
    BookingDto findBookingById(Long idBooking);
    BookingDto createBooking(BookingDto bookingDto);
    boolean updateBooking (Long idBooking, BookingDto bookingDto);
    boolean deleteBooking(Long idBooking);
}
