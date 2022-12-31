package com.bookingsproject.bookingsproject.model;

import com.bookingsproject.bookingsproject.dto.booking.BookingDto;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    private static final long serialVersionUID = 1L;

    @Id
    private String bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String email;
    private String password;

    public Booking() {
    }

    public Booking (LocalDate checkIn, LocalDate checkOut, String email, String password) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.email = email;
        this.password = password;
    }


    public Booking (BookingDto bookingDto) {
        this.checkIn= bookingDto.getCheckIn();
        this.checkOut = bookingDto.getCheckOut();
        this.email = bookingDto.getEmail();
        this.password = bookingDto.getPassword();
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(checkIn, booking.checkIn) && Objects.equals(checkOut, booking.checkOut) && Objects.equals(email, booking.email) && Objects.equals(password, booking.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, checkIn, checkOut, email, password);
    }
}
