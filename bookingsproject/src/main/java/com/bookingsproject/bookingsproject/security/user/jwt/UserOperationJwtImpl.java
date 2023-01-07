package com.bookingsproject.bookingsproject.security.user.jwt;

import com.bookingsproject.bookingsproject.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class UserOperationJwtImpl implements UserOperationJwt{


    final String keySecret = "FelipeADA123";
    @Override
    public String generateJwt(User user, Calendar expirationDate) {

        return Jwts.builder()
                .setSubject(user.getUserId())
                .claim("name", user.getFullName())
                .claim("email",user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }

    @Override
    public Boolean validateJwt(String jwt, User user) {
        Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
        Boolean isValidJwt = user.getUserId().equals(extractSubject(jwt)) && !isJwtExpired;
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
