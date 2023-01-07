package com.bookings.bookings.repository;

import com.bookings.bookings.model.Booking;
import com.bookings.bookings.model.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepositoryDao {


    private final BookingMongoRepository bookingCrudRepository;

    @Autowired
    public BookingRepositoryImpl (BookingMongoRepository bookingCrudRepository){
        this.bookingCrudRepository = bookingCrudRepository;
    }


    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookingsFound = new ArrayList<>();
        bookingCrudRepository.findAll().forEach(booking ->bookingsFound.add(booking));
        return bookingsFound;
    }

    @Override
    public Booking findBookingById(String idBooking) {
        Optional<Booking> bookingFound = bookingCrudRepository.findById(idBooking);
        if(bookingFound.isPresent()){
            return bookingFound.get();
        }else{
            return null;
        }

    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto);
        return bookingCrudRepository.save(booking);
    }

    @Override
    public Booking updateBooking(String idBooking, BookingDto bookingDto) {
        Booking bookingFound = findBookingById(idBooking);
        if(bookingFound != null){
            bookingFound.setCheckIn(bookingDto.getCheckIn());
            bookingFound.setCheckOut(bookingDto.getCheckOut());
            bookingFound.setEmail(bookingDto.getEmail());
            bookingFound.setPassword(bookingDto.getPassword());
            return bookingCrudRepository.save(bookingFound);
        }else{
            return null;
        }

    }

    @Override
    public Boolean deleteBooking(String idBooking) {
        Booking bookingFound = findBookingById(idBooking);
        if(bookingFound != null){
            bookingCrudRepository.delete(bookingFound);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Booking findByEmail(String email) {
        Optional<Booking> bookingFound = bookingCrudRepository.findByEmail(email);
        if (bookingFound.isPresent()){
            return bookingFound.get();
        }else{
            return null;
        }
    }
}
