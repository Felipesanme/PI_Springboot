package com.bookings.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

//@Entity
//@Table(name = "users")
@Document(collection = "user_collection_MDB")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_user")
    private String idUser;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "idUser='" + idUser + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
