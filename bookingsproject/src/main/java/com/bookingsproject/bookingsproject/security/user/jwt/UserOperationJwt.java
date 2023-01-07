package com.bookingsproject.bookingsproject.security.user.jwt;

import com.bookingsproject.bookingsproject.model.User;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface UserOperationJwt {

    String generateJwt(User user, Calendar expirationDate);

    Boolean validateJwt(String jwt, User user);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);
}
