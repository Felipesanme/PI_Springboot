package com.bookingsproject.bookingsproject.service.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

   private final BookingRepository bookingRepository;

   @Autowired
   public BookingServiceImpl (BookingRepository bookingRepository){
       this.bookingRepository = bookingRepository;
   }


    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(String id) {
        return this.bookingRepository.findById(id);
    }

    @Override
    public Booking createBooking(BookingDto bookingDto) {
        return bookingRepository.createBooking(bookingDto);
    }

    @Override
    public Booking updateBooking(String id, BookingDto bookingDto) {
        return bookingRepository.updateBooking(id,bookingDto);
    }

    @Override
    public Boolean deleteBooking(String id) {
        return bookingRepository.deleteBooking(id);
    }

    @Override
    public Booking findByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }
}
