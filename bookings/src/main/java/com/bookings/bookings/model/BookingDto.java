package com.bookings.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

//@Entity
//@Table(name = "bookings")
@Document(collection = "booking_collection")
public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_booking")
    private String idBooking;
//    @Column(name = "check_in")
    private LocalDate checkIn;
//    @Column(name = "check_out")
    private LocalDate checkOut;

    private String email;

    private String password;
//    @Column(name = "id_user")
//    private String idUser;

//    @ManyToOne
//    @JoinColumn(name = "id_user", insertable = false, updatable = false)
//    private UserDto userDto;

    public BookingDto(){

    }

    public BookingDto(LocalDate checkIn, LocalDate checkOut, String email, String password) {

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.password = password;
        this.email = email;
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
        return "BookingDto{" +
                "idBooking='" + idBooking + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", email='" + email + '\'' +
                '}';
    }
}
