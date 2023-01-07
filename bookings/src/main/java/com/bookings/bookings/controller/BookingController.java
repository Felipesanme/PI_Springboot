package com.bookings.bookings.controller;


import com.bookings.bookings.model.Booking;
import com.bookings.bookings.model.BookingDto;
import com.bookings.bookings.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController (BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.getAllBookings(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findUserById(@PathVariable("id") String idBooking){
        return new ResponseEntity<>(bookingService.findBookingById(idBooking), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking (@RequestBody BookingDto bookingDto){
        Booking booking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") String idBooking, @RequestBody BookingDto bookingDto){
        Booking booking = bookingService.updateBooking(idBooking,bookingDto);
        if(booking != null){
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }else{
            return new ResponseEntity("Updating user error",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean>deleteBooking (@PathVariable("id") String idBooking){
        Boolean isDelete = bookingService.deleteBooking(idBooking);
        if(isDelete){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
