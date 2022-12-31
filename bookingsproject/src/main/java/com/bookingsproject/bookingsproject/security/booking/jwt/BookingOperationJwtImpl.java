package com.bookingsproject.bookingsproject.security.booking.jwt;

import com.bookingsproject.bookingsproject.model.Booking;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class BookingOperationJwtImpl implements BookingOperationJwt {
    @Override
    public String generateJwt(Booking booking, Calendar expirationDate) {
        final String keySecret = "ADA_Secret*123";
        return Jwts.builder()
                .setSubject(booking.getBookingId())
                .claim("email", booking.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }
}
