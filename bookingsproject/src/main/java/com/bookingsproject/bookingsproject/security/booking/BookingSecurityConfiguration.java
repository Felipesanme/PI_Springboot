//package com.bookingsproject.bookingsproject.security.booking;
//
//import com.bookingsproject.bookingsproject.security.booking.jwt.BookingJwtRequestFilter;
//import com.bookingsproject.bookingsproject.service.booking.BookingDetailServiceAuth;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//public class BookingSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private BookingDetailServiceAuth bookingDetailServiceAuth;
//
//    @Autowired
//    private BookingJwtRequestFilter bookingJwtRequestFilter;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(bookingDetailServiceAuth);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/v0/booking_auth").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(bookingJwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//}
