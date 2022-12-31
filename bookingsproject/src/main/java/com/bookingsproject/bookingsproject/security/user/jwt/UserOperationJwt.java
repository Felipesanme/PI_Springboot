package com.bookingsproject.bookingsproject.security.user.jwt;

import com.bookingsproject.bookingsproject.model.User;

import java.util.Calendar;

public interface UserOperationJwt {

    String generateJwt(User user, Calendar expirationDate);
}
