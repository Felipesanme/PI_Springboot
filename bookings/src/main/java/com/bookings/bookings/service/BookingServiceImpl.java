package com.bookings.bookings.service;

import com.bookings.bookings.model.Booking;
import com.bookings.bookings.model.BookingDto;
import com.bookings.bookings.repository.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private BookingRepositoryDao bookingRepositoryDao;

    @Autowired
    public BookingServiceImpl (BookingRepositoryDao bookingRepositoryDao){
        this.bookingRepositoryDao =bookingRepositoryDao;
    }
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepositoryDao.getAllBookings();
    }

    @Override
    public Booking findBookingById(String idBooking) {
        return bookingRepositoryDao.findBookingById(idBooking);
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        return bookingRepositoryDao.createBooking(bookingDto);
    }

    @Override
    public Booking updateBooking(String idBooking, BookingDto bookingDto) {
        return bookingRepositoryDao.updateBooking(idBooking, bookingDto);
    }

    @Override
    public Boolean deleteBooking(String idBooking) {
        return bookingRepositoryDao.deleteBooking(idBooking);
    }

    @Override
    public Booking findByEmail(String email) {
        return bookingRepositoryDao.findByEmail(email);
    }
}
