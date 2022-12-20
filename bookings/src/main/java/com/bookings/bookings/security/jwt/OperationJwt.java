package com.bookings.bookings.security.jwt;

import com.bookings.bookings.model.UserDto;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface OperationJwt {
    String generateJwt(UserDto userDto, Calendar expirationDate);
    Boolean validateJwt(String jwt, UserDto userDto);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);
}
