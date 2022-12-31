package com.bookingsproject.bookingsproject.security.booking.jwt;

import com.bookingsproject.bookingsproject.model.Booking;

import java.util.Calendar;

public interface BookingOperationJwt {

    String generateJwt(Booking booking, Calendar expirationDate);

}
