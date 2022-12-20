package com.bookings.bookings.configuration;

import com.bookings.bookings.security.jwt.OperationJwt;
import com.bookings.bookings.security.jwt.OperationJwtImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public OperationJwt tokenGeneration(){
        return new OperationJwtImpl();
    }
}
