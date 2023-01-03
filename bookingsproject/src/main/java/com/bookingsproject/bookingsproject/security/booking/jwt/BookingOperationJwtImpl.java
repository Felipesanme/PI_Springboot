package com.bookingsproject.bookingsproject.security.booking.jwt;

import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class BookingOperationJwtImpl implements BookingOperationJwt {

    final String keySecret = "FelipeADA123";
    @Override
    public String generateJwt(Booking booking, Calendar expirationDate) {

        return Jwts.builder()
                .setSubject(booking.getBookingId())
                .claim("email", booking.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }

    @Override
    public Boolean validateJwt(String jwt, Booking booking) {
        Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
        Boolean isValidJwt = booking.getBookingId().equals(extractSubject(jwt)) && !isJwtExpired;
        return isValidJwt;
    }

    @Override
    public Claims returnClaims(String jwt) {
        return Jwts.parser().setSigningKey(keySecret).parseClaimsJws(jwt).getBody();
    }

    @Override
    public String extractSubject(String jwt) {
        return returnClaims(jwt).getSubject();
    }
}
