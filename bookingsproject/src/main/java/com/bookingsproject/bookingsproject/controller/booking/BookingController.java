package com.bookingsproject.bookingsproject.controller.booking;


import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import com.bookingsproject.bookingsproject.dto.user.UserDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController (BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findAll(){
        List<Booking> bookings = bookingService.findAll();
        if(bookings.size()==0){
            return new ResponseEntity("The collection bookings is empty", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(bookings,HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable String id) {
        Booking booking = bookingService.findById(id);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity("The id " + id + " is not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto){
        Booking booking = bookingService.createBooking(bookingDto);
        if (booking != null){
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        }else {
            return new ResponseEntity("Error creating booking", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody BookingDto bookingDto){
        Booking booking = bookingService.updateBooking(id, bookingDto);
        if (booking != null){
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }else {
            return new ResponseEntity("Error updating booking", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable String id){
        Boolean isDeleted = bookingService.deleteBooking(id);
        if (isDeleted){
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }
    }
}


