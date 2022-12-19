package com.bookings.bookings.repository;

import com.bookings.bookings.model.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepositoryDao {

    @Autowired
    private BookingMongoRepository bookingCrudRepository;


    @Override
    public List<BookingDto> getAllBookings() {
        List<BookingDto> bookingsFound = new ArrayList<>();
        bookingCrudRepository.findAll().forEach(booking ->bookingsFound.add(booking));
        return bookingsFound;
    }

    @Override
    public BookingDto findBookingById(String idBooking) {
        return bookingCrudRepository.findById(idBooking).get();
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingCrudRepository.save(bookingDto);
    }

    @Override
    public boolean updateBooking(String idBooking, BookingDto bookingDto) {
        BookingDto bookingFound = findBookingById(idBooking);
        if(bookingFound != null){
            bookingFound.setCheckIn(bookingDto.getCheckIn());
            bookingFound.setCheckOut(bookingDto.getCheckOut());
            bookingCrudRepository.save(bookingFound);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteBooking(String idBooking) {
        BookingDto bookingFound = findBookingById(idBooking);
        if(bookingFound != null){
            bookingCrudRepository.delete(bookingFound);
            return true;
        }else{
            return false;
        }

    }
}
