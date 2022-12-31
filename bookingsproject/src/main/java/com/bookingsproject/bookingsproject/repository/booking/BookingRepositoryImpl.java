package com.bookingsproject.bookingsproject.repository.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.repository.booking.mongo.BookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepositoryImpl implements BookingRepository{
    private final BookingMongoRepository bookingMongoRepository;

    @Autowired
    public BookingRepositoryImpl(BookingMongoRepository bookingMongoRepository) {
        this.bookingMongoRepository = bookingMongoRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingMongoRepository.findAll();
    }

    @Override
    public Booking findById(String id) {
        Optional<Booking> bookingFound = bookingMongoRepository.findById(id);
        if (bookingFound.isPresent()){
            return bookingFound.get();
        }else {
            return null;
        }
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        Booking booking = new Booking(bookingDto);
        return bookingMongoRepository.save(booking);
    }

    @Override
    public Booking updateBooking(String id, BookingDto bookingDto) {
        Booking bookingFound = findById(id);
        if (bookingFound != null){
            bookingFound.setCheckIn(bookingDto.getCheckIn());
            bookingFound.setEmail(bookingDto.getEmail());
            bookingFound.setCheckOut(bookingDto.getCheckOut());
            return bookingMongoRepository.save(bookingFound);
        }else {
            return null;
        }
    }

    @Override
    public Boolean deleteBooking(String id) {
        Booking bookingFound = findById(id);
        if (bookingFound != null){
            bookingMongoRepository.delete(bookingFound);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Booking findByEmail(String email) {
        Optional<Booking> bookingFound = bookingMongoRepository.findByEmail(email);
        if (bookingFound.isPresent()){
            return bookingFound.get();
        }else{
            return null;
        }
    }
}
