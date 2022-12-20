package com.bookings.bookings.security.jwt;

import com.bookings.bookings.model.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

public class OperationJwtImpl implements OperationJwt {
    final String keySecret = "felipeADA123+";

    @Override
    public String generateJwt(UserDto userDto, Calendar expirationDate) {
        ;
        return Jwts.builder()
                .setSubject(userDto.getIdUser())
                .claim("fullName",userDto.getFullName())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256,keySecret)
                .compact();
    }

    @Override
    public Boolean validateJwt(String jwt, UserDto userDto) {
        Boolean isJwtExpired =returnClaims(jwt).getExpiration().before(new Date());
        Boolean isValidJwt = userDto.getIdUser().equals(extractSubject(jwt)) && ! isJwtExpired;
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
