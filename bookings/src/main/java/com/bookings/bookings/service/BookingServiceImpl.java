package com.bookings.bookings.service;

import com.bookings.bookings.model.BookingDto;
import com.bookings.bookings.repository.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingRepositoryDao {

    @Autowired
    private BookingRepositoryDao bookingRepositoryDao;

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepositoryDao.getAllBookings();
    }

    @Override
    public BookingDto findBookingById(String idBooking) {
        return bookingRepositoryDao.findBookingById(idBooking);
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingRepositoryDao.createBooking(bookingDto);
    }

    @Override
    public boolean updateBooking(String idBooking, BookingDto bookingDto) {
        return bookingRepositoryDao.updateBooking(idBooking, bookingDto);
    }

    @Override
    public boolean deleteBooking(String idBooking) {
        return bookingRepositoryDao.deleteBooking(idBooking);
    }

    @Override
    public BookingDto findByEmail(String email) {
        return bookingRepositoryDao.findByEmail(email);
    }
}
