package com.bookings.bookings.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Long idBooking;
    @Column(name = "check_in")
    private LocalDate checkIn;
    @Column(name = "check_out")
    private LocalDate checkOut;
    @Column(name = "id_user")
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserDto userDto;

    public BookingDto(){

    }

    public BookingDto(LocalDate checkIn, LocalDate checkOut) {

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
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

    @Override
    public String toString() {
        return "BookingDto{" +
                "idBooking=" + idBooking +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
