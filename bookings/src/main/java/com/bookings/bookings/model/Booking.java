package com.bookings.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Document(collection = "booking_collection")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String idBooking;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String email;
    private String password;

    public Booking(){

    }

    public Booking(LocalDate checkIn, LocalDate checkOut, String email, String password) {

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.password = password;
        this.email = email;
    }

    public Booking (BookingDto bookingDto){
        this.checkIn = bookingDto.getCheckIn();
        this.checkOut = bookingDto.getCheckOut();
        this.password = bookingDto.getPassword();
        this.email = bookingDto.getEmail();
    }



    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
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
                "idBooking='" + idBooking + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking that = (Booking) o;
        return Objects.equals(idBooking, that.idBooking) && Objects.equals(checkIn, that.checkIn) && Objects.equals(checkOut, that.checkOut) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, checkIn, checkOut, email, password);
    }
}
