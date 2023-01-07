package com.bookingsproject.bookingsproject.security.booking.jwt;

import com.bookingsproject.bookingsproject.model.Booking;
import com.bookingsproject.bookingsproject.model.User;
import com.bookingsproject.bookingsproject.security.user.jwt.UserOperationJwt;
import com.bookingsproject.bookingsproject.service.booking.BookingDetailServiceAuth;
import com.bookingsproject.bookingsproject.service.booking.BookingService;
import com.bookingsproject.bookingsproject.service.user.UserDetailServiceAuth;
import com.bookingsproject.bookingsproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class BookingJwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private BookingOperationJwt operationJwt;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingDetailServiceAuth bookingDetailServiceAuth;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            String jwt = authorizationHeader.substring(7);
            String idBooking = operationJwt.extractSubject(jwt);

            if (idBooking != null && SecurityContextHolder.getContext().getAuthentication() == null){
                Booking bookingFound = bookingService.findById(idBooking);

                if (operationJwt.validateJwt(jwt, bookingFound)){
                    UserDetails userDetails = bookingDetailServiceAuth.loadUserByUsername(bookingFound.getEmail());
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails
                                    ,null
                                    ,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource()
                            .buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

}
