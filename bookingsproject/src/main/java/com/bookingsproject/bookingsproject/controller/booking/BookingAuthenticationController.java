package com.bookingsproject.bookingsproject.controller.booking;

import com.bookingsproject.bookingsproject.dto.booking.BookingLoginDto;
import com.bookingsproject.bookingsproject.dto.booking.BookingTokenDto;
import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.security.booking.jwt.BookingOperationJwt;
import com.bookingsproject.bookingsproject.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/v0/booking_auth")
public class BookingAuthenticationController {
    private final BookingOperationJwt bookingOperationJwt;
    private final BookingService bookingService;

    @Autowired
    public BookingAuthenticationController(BookingOperationJwt bookingoperationJwt, BookingService bookingService) {
        this.bookingOperationJwt = bookingoperationJwt;
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingTokenDto> generateJwt(@RequestBody BookingLoginDto bookingLoginDto){
        Booking bookingFound = bookingService.findByEmail(bookingLoginDto.getEmail());
        if (bookingFound != null){
            Calendar dateExpiration = Calendar.getInstance();
            dateExpiration.add(Calendar.MINUTE, 20);
            String jwt = bookingOperationJwt.generateJwt(bookingFound, dateExpiration);
            BookingTokenDto bookingTokenDto = new BookingTokenDto(jwt, dateExpiration.getTime());
            return new ResponseEntity<>(bookingTokenDto, HttpStatus.OK);
        }else {
            return new ResponseEntity("email " + bookingLoginDto.getEmail()
                    + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
