package com.bookingsproject.bookingsproject.security.user.jwt;

import com.bookingsproject.bookingsproject.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class UserOperationJwtImpl implements UserOperationJwt{

    @Override
    public String generateJwt(User user, Calendar expirationDate) {
        final String keySecret = "ADA_Secret*123";
        return Jwts.builder()
                .setSubject(user.getUserId())
                .claim("name", user.getFullName())
                .claim("email",user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }
}
