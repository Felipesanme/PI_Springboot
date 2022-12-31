package com.bookingsproject.bookingsproject.dto.user;

import java.io.Serializable;
import java.util.Date;

public class UserTokenDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jwt;
    private Date expirationJwt;

    public UserTokenDto() {
    }

    public UserTokenDto(String jwt, Date expirationJwt) {
        this.jwt = jwt;
        this.expirationJwt = expirationJwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpirationJwt() {
        return expirationJwt;
    }

    public void setExpirationJwt(Date expirationJwt) {
        this.expirationJwt = expirationJwt;
    }
}
