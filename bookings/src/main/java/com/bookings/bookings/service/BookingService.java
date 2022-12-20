package com.bookings.bookings.service;

import com.bookings.bookings.model.BookingDto;

import java.util.List;

public interface BookingService {
    List<BookingDto> getAllBookings();
    BookingDto findBookingById(String idBooking);
    BookingDto createBooking(BookingDto bookingDto);
    boolean updateBooking(Long idBooking,BookingDto bookingDto);
    boolean deleteBooking(Long idBooking);

    BookingDto findByEmail(String email);

}
