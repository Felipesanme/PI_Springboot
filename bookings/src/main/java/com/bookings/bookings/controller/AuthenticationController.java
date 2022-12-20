package com.bookings.bookings.controller;

import com.bookings.bookings.model.LoginDto;
import com.bookings.bookings.model.TokenDto;
import com.bookings.bookings.model.User;
import com.bookings.bookings.security.jwt.OperationJwt;
import com.bookings.bookings.service.UserService;
import com.bookings.bookings.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {


    private final OperationJwt operationJwt;
    private final UserService userService;
//    private final BookingServiceImpl bookingService;

    @Autowired
    public AuthenticationController(OperationJwt operationJwt, UserServiceImpl userService) {
        this.operationJwt = operationJwt;
        this.userService = userService;
//        this.bookingService = bookingService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity<TokenDto> generateJwt(@RequestBody LoginDto loginDto){

        User userFound = userService.findByEmail(loginDto.getEmail());
        if(userFound!= null){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(),loginDto.getPassword()));
            Calendar expirationDate = Calendar.getInstance();
            expirationDate.add(Calendar.MINUTE,5);
            String jwt = operationJwt.generateJwt(userFound,expirationDate);
            TokenDto tokenDto = new TokenDto(jwt,expirationDate.getTime());
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);
        }else{
            return new ResponseEntity("Email " + loginDto.getEmail() + "Not found", HttpStatus.NOT_FOUND);
        }


    }
}
