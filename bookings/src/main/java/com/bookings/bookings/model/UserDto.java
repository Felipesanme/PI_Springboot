package com.bookings.bookings.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

//@Entity
//@Table(name = "users")

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_user")

//    @Column(name = "full_name")
    private String fullName;
    private String email;

    private String password;

//    @OneToMany(mappedBy = "userDto")
//    private List<BookingDto> bookingDtos;

    public UserDto(String fullName, String email, String password) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public UserDto(){

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

