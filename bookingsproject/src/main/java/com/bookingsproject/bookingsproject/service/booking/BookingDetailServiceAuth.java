package com.bookingsproject.bookingsproject.service.booking;

import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.repository.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookingDetailServiceAuth implements UserDetailsService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Booking bookingFound = bookingRepository.findByEmail(email);
        return new User(bookingFound.getEmail()
                , "{noop}" + bookingFound.getPassword(), new ArrayList<>());

    }
}
