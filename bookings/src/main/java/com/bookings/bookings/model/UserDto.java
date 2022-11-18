package com.bookings.bookings.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "full_name")
    private String fullName;
    private String email;

    @OneToMany(mappedBy = "userDto")
    private List<BookingDto> bookingDtos;

    public UserDto(String fullName, String email) {

        this.fullName = fullName;
        this.email = email;
    }

    public UserDto(){

    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
