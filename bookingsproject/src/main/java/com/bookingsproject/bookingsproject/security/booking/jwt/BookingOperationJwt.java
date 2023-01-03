package com.bookingsproject.bookingsproject.security.booking.jwt;
import com.bookingsproject.bookingsproject.model.Booking;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface BookingOperationJwt {

    String generateJwt(Booking booking, Calendar expirationDate);

    Boolean validateJwt(String jwt, Booking booking);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);

}
