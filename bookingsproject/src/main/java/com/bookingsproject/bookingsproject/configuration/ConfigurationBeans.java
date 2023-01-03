package com.bookingsproject.bookingsproject.configuration;

//import com.bookingsproject.bookingsproject.security.booking.jwt.BookingOperationJwtImpl;
//import com.bookingsproject.bookingsproject.security.booking.jwt.BookingOperationJwt;
import com.bookingsproject.bookingsproject.security.booking.jwt.BookingOperationJwt;
import com.bookingsproject.bookingsproject.security.booking.jwt.BookingOperationJwtImpl;
import com.bookingsproject.bookingsproject.security.user.jwt.UserOperationJwt;
import com.bookingsproject.bookingsproject.security.user.jwt.UserOperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public UserOperationJwt userGenerationToken(){
        return new UserOperationJwtImpl();
    }

    @Bean
    public BookingOperationJwt bookingGenerationToken(){
        return new BookingOperationJwtImpl();
    }

}
