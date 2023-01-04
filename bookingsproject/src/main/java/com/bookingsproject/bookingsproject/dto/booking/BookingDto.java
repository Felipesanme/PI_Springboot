package com.bookingsproject.bookingsproject.dto.booking;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private String email;
    private String password;

    public BookingDto() {
    }

    public BookingDto(LocalDate checkIn, LocalDate checkOut, String email, String password) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.email = email;
        this.password = password;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
